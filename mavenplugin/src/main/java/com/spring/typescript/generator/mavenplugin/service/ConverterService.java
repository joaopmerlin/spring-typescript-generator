package com.spring.typescript.generator.mavenplugin.service;

import com.spring.typescript.generator.annotation.TsIgnore;
import com.spring.typescript.generator.annotation.TsModel;
import com.spring.typescript.generator.mavenplugin.model.Arquivo;
import com.spring.typescript.generator.mavenplugin.model.Atributo;
import com.spring.typescript.generator.mavenplugin.model.Model;
import com.spring.typescript.generator.mavenplugin.model.Tipos;
import sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

public abstract class ConverterService<T> {

    abstract List<T> converter(Set<Class<?>> classes);

    protected Model getModel(Class<?> aClass) {
        Model model = new Model();
        model.setNome(aClass.getSimpleName());

        TsModel tsModel = aClass.getAnnotation(TsModel.class);
        if (!tsModel.value().isEmpty()) {
            model.setNomeArquivo(tsModel.value());
        }

        model.setEncapsular(tsModel.encapsulate());

        Arrays.asList(aClass.getDeclaredFields()).forEach(field -> {
            field.setAccessible(true);

            if (!field.isAnnotationPresent(TsIgnore.class)) {

                Atributo atributo = new Atributo();
                atributo.setNome(field.getName());
                atributo.setTipo(getType(field, model));

                model.addAtributo(atributo);
            }
        });

        return model;
    }

    protected String getType(Field field, Arquivo arquivo) {
        AtomicReference<String> tipo = new AtomicReference<>("any");

        if (Iterable.class.isAssignableFrom(field.getType())) {
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
                if (key.isAssignableFrom(field.getType())) {
                    tipo.set(value);
                    return;
                }
            });
        }

        return tipo.get();
    }
}
