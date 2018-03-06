package com.spring.typescript.generator.mavenplugin.service;

import com.spring.typescript.generator.annotation.TsModel;
import com.spring.typescript.generator.annotation.TsService;
import com.spring.typescript.generator.mavenplugin.model.Metodo;
import com.spring.typescript.generator.mavenplugin.model.Service;
import com.spring.typescript.generator.mavenplugin.model.Tipos;
import org.apache.commons.lang3.ClassUtils;
import sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class ConverterControllerService extends ConverterService<Service> {

    private SpringService springService = new SpringService();

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
                metodo.setMethod(springService.getMethod(method));
                metodo.setParametros(springService.getParametros(method, service));
                metodo.setUrl(springService.getUrl(aClass, method, metodo.getParametros()));
                service.addMetodo(metodo);
            });

            services.add(service);
        });
        return services;
    }

    private void setRetorno(Method method, Metodo metodo, Service service) {
        if (ClassUtils.isAssignable(method.getReturnType(), Iterable.class)) {
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
                if (ClassUtils.isAssignable(method.getReturnType(), key)) {
                    metodo.setRetorno(value);
                    return;
                }
            });
        }
    }
}
