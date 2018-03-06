package com.spring.typescript.generator.mavenplugin.service;

import com.spring.typescript.generator.annotation.TsModel;
import com.spring.typescript.generator.annotation.TsService;
import com.spring.typescript.generator.mavenplugin.model.Metodo;
import com.spring.typescript.generator.mavenplugin.model.Service;
import com.spring.typescript.generator.mavenplugin.model.Tipos;
import sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl;

import java.lang.reflect.Method;
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
                setRetorno(method, metodo, service);
                metodo.setMethod("get");
                metodo.setUrl("/teste");

                service.addMetodo(metodo);
            });

            services.add(service);
        });
        return services;
    }

    private void setRetorno(Method method, Metodo metodo, Service service) {
        if (Iterable.class.isAssignableFrom(method.getReturnType())) {
            Class type = (Class) ((ParameterizedTypeImpl) method.getGenericReturnType()).getActualTypeArguments()[0];

            if (type.isAnnotationPresent(TsModel.class)){
                metodo.setRetorno(type.getSimpleName() + "[]");
                service.addImport(getModel(type));
            } else {
                metodo.setRetorno("any[]");
            }

        } else if (method.getReturnType().isAnnotationPresent(TsModel.class)) {
            metodo.setRetorno(method.getReturnType().getSimpleName());
            service.addImport(getModel(method.getReturnType()));
        }

        else {
            Tipos.getTipos().forEach((key, value) -> {
                if (key.isAssignableFrom(method.getReturnType())) {
                    metodo.setRetorno(value);
                    return;
                }
            });
        }
    }
}
