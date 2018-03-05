package com.spring.typescript.generator.mavenplugin.service;

import java.util.List;
import java.util.Set;

public abstract class ConverterService<T> {

    abstract List<T> converter(Set<Class<?>> classes);
}
