package com.spring.typescript.generator.mavenplugin.converter;

import com.spring.typescript.generator.annotation.TsComponent;
import com.spring.typescript.generator.annotation.TsModel;
import com.spring.typescript.generator.mavenplugin.model.Component;
import com.spring.typescript.generator.mavenplugin.model.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ComponentConverter extends AbstractConverter<Component> implements Converter<Component> {

    private ServiceConverter serviceConverter = new ServiceConverter();

    @Override
    public List<Component> converter(Set<Class<?>> classes) {
        List<Component> components = new ArrayList<>();
        classes.forEach(aClass -> components.add(getComponent(aClass)));
        return components;
    }

    public Component getComponent(Class<?> aClass) {
        Component component = new Component();

        TsComponent tsComponent = aClass.getAnnotation(TsComponent.class);
        Class<?> clazz = tsComponent.value();
        if (!clazz.isAnnotationPresent(TsModel.class)) {
            throw new RuntimeException();
        }
        Model model = getModel(clazz);
        component.setNome(model.getNome());
        component.setService(serviceConverter.getService(aClass));

        if (tsComponent.crud()) {
            component.setCrud(true);
        }

        model.getAtributos().forEach(attr -> {
            if (attr.getRelationShip()) {
                component.addImport(new Model(attr.getTipo() + "Service"));
            }
        });

        return component;
    }
}
