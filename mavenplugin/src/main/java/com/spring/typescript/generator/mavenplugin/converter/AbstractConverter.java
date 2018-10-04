package com.spring.typescript.generator.mavenplugin.converter;

import com.spring.typescript.generator.annotation.TsIgnore;
import com.spring.typescript.generator.annotation.TsModel;
import com.spring.typescript.generator.annotation.TsRelationship;
import com.spring.typescript.generator.mavenplugin.model.Arquivo;
import com.spring.typescript.generator.mavenplugin.model.Atributo;
import com.spring.typescript.generator.mavenplugin.model.Model;
import com.spring.typescript.generator.mavenplugin.model.Tipos;
import com.spring.typescript.generator.mavenplugin.service.TipoComponenteService;
import org.apache.commons.lang3.ClassUtils;
import sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl;

import javax.persistence.GeneratedValue;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

public abstract class AbstractConverter<T> implements Converter<T> {

    public abstract List<T> converter(Set<Class<?>> classes);

    public Model getModel(Class<?> aClass) {
        Model model = new Model();
        model.setNome(aClass.getSimpleName());

        TsModel tsModel = aClass.getAnnotation(TsModel.class);
        if (!tsModel.value().isEmpty()) {
            model.setNome(tsModel.value());
        }

        model.setModifier(Modifier.isAbstract(aClass.getModifiers()) ? "abstract " : "");

        Arrays.asList(aClass.getDeclaredFields()).forEach(field -> {
            field.setAccessible(true);

            if (!field.isAnnotationPresent(TsIgnore.class)) {

                Atributo atributo = new Atributo();
                atributo.setNome(field.getName());
                atributo.setTipo(getType(field, model));
                atributo.setTipoComponente(TipoComponenteService.getTipoComponente(field));

                if (field.isAnnotationPresent(GeneratedValue.class)) {
                    atributo.setDisabled(true);
                }

                if (field.isAnnotationPresent(TsRelationship.class)) {
                    TsRelationship relationship = field.getAnnotation(TsRelationship.class);
                    atributo.setRelationShip(true);
                    atributo.setRelationShipLabel(relationship.label());
                }

                model.addAtributo(atributo);
            }
        });

        return model;
    }

    protected String getType(Field field, Arquivo arquivo) {
        AtomicReference<String> tipo = new AtomicReference<>("any");

        if (ClassUtils.isAssignable(field.getType(), Iterable.class)) {
            Class type = (Class)((ParameterizedTypeImpl) field.getGenericType()).getActualTypeArguments()[0];

            if (type.isAnnotationPresent(TsModel.class)){
                tipo.set(type.getSimpleName() + "[]");
                arquivo.addImport(getModel(type));
            } else {
                tipo.set("any[]");
            }
        }

        else if (field.getType().isAnnotationPresent(TsModel.class)) {
            tipo.set(field.getType().getSimpleName());
            arquivo.addImport(getModel(field.getType()));
        }

        else {
            Tipos.getTipos().forEach((key, value) -> {
                if (ClassUtils.isAssignable(field.getType(), key)) {
                    tipo.set(value);
                    return;
                }
            });
        }

        return tipo.get();
    }
}
