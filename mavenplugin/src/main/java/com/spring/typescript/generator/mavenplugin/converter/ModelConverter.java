package com.spring.typescript.generator.mavenplugin.converter;

import com.spring.typescript.generator.mavenplugin.model.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ModelConverter extends AbstractConverter<Model> implements Converter<Model> {

    @Override
    public List<Model> converter(Set<Class<?>> classes) {
        List<Model> models = new ArrayList<>();
        classes.forEach(aClass -> models.add(getModel(aClass)));
        return models;
    }
}
