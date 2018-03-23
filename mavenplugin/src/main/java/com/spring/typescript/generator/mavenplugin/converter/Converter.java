package com.spring.typescript.generator.mavenplugin.converter;

import com.spring.typescript.generator.mavenplugin.model.Model;

import java.util.List;
import java.util.Set;

public interface Converter<T> {

    List<T> converter(Set<Class<?>> classes);

    Model getModel(Class<?> aClass);
}
