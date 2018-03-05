package com.spring.typescript.generator.mavenplugin.service;

import com.spring.typescript.generator.annotation.TsModel;
import com.spring.typescript.generator.annotation.TsService;
import org.reflections.Reflections;

import java.lang.annotation.Annotation;
import java.util.Set;

public class ClassService {

    private Reflections ref = new Reflections();

    public Set<Class<?>> getModels() {
        return getClasses(TsModel.class);
    }

    public Set<Class<?>> getServices() {
        return getClasses(TsService.class);
    }

    private Set<Class<?>> getClasses(Class<? extends Annotation> c) {
        return ref.getTypesAnnotatedWith(c);
    }
}
