package com.spring.typescript.generator.mavenplugin.service;

import com.spring.typescript.generator.annotation.TsService;
import com.spring.typescript.generator.mavenplugin.model.Metodo;
import com.spring.typescript.generator.mavenplugin.model.Service;
import sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class ConverterControllerService extends ConverterService<Service> {

    @Override
    public List<Service> converter(Set<Class<?>> classes) {
        List<Service> services = new ArrayList<>();
        classes.forEach(aClass -> {
            Service service = new Service();

            service.setNome(aClass.getSimpleName());
            TsService tsService = aClass.getAnnotation(TsService.class);
            if (!tsService.value().isEmpty()) {
                service.setNomeArquivo(tsService.value());
            }

            Arrays.asList(aClass.getDeclaredMethods()).forEach(method -> {
                Metodo metodo = new Metodo();
                metodo.setNome(method.getName());

                if (Iterable.class.isAssignableFrom(method.getReturnType())) {
                    Class type = (Class) ((ParameterizedTypeImpl) method.getGenericReturnType()).getActualTypeArguments()[0];
                    // metodo.setRetorno(getType(type, null) + "[]");
                } else {
                    // metodo.setRetorno(getModel(method.getReturnType()));
                }

                service.addMetodo(metodo);
            });

            services.add(service);
        });
        return services;
    }
}
