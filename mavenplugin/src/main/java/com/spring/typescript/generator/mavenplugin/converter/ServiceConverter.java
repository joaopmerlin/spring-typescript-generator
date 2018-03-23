package com.spring.typescript.generator.mavenplugin.converter;

import com.spring.typescript.generator.annotation.TsComponent;
import com.spring.typescript.generator.annotation.TsModel;
import com.spring.typescript.generator.mavenplugin.model.Metodo;
import com.spring.typescript.generator.mavenplugin.model.Model;
import com.spring.typescript.generator.mavenplugin.model.Service;
import com.spring.typescript.generator.mavenplugin.model.Tipos;
import com.spring.typescript.generator.mavenplugin.service.SpringService;
import org.apache.commons.lang3.ClassUtils;
import sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class ServiceConverter extends AbstractConverter<Service> implements Converter<Service> {

    private SpringService springService = new SpringService();
    private Converter<Model> converter = new ModelConverter();

    @Override
    public List<Service> converter(Set<Class<?>> classes) {
        List<Service> services = new ArrayList<>();
        classes.forEach(aClass -> services.add(getService(aClass)));
        return services;
    }

    public Service getService(Class<?> aClass) {
        Service service = new Service();

        TsComponent component = aClass.getAnnotation(TsComponent.class);
        Class<?> clazz = component.value();
        if (!clazz.isAnnotationPresent(TsModel.class)) {
            throw new RuntimeException();
        }
        Model model = getModel(clazz);
        service.setNome(model.getNome());

        Arrays.asList(aClass.getDeclaredMethods()).forEach(method -> {
            Metodo metodo = new Metodo();
            metodo.setNome(method.getName());
            setRetorno(method, metodo, service);
            metodo.setMethod(springService.getMethod(method));
            metodo.setParametros(springService.getParametros(method, service));
            metodo.setUrl(springService.getUrl(aClass, method, metodo.getParametros()));
            service.addMetodo(metodo);
        });

        return service;
    }

    private void setRetorno(Method method, Metodo metodo, Service service) {
        if (ClassUtils.isAssignable(method.getReturnType(), Iterable.class)) {
            Class type = (Class) ((ParameterizedTypeImpl) method.getGenericReturnType()).getActualTypeArguments()[0];

            if (type.isAnnotationPresent(TsModel.class)){
                Model model = converter.getModel(type);
                metodo.setRetorno(model.getNome() + "[]");
                service.addImport(getModel(type));
            } else {
                metodo.setRetorno("any[]");
            }

        } else if (method.getReturnType().isAnnotationPresent(TsModel.class)) {
            Model model = converter.getModel(method.getReturnType());
            metodo.setRetorno(model.getNome());
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
