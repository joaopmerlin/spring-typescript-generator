package com.spring.typescript.generator.mavenplugin.converter;

import com.spring.typescript.generator.annotation.TsComponent;
import com.spring.typescript.generator.annotation.TsModel;
import com.spring.typescript.generator.mavenplugin.model.Model;
import com.spring.typescript.generator.mavenplugin.model.Module;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ModuleConverter extends AbstractConverter<Module> implements Converter<Module> {

    private ServiceConverter serviceConverter = new ServiceConverter();
    private ComponentConverter componentConverter = new ComponentConverter();

    @Override
    public List<Module> converter(Set<Class<?>> classes) {
        List<Module> modules = new ArrayList<>();

        classes.forEach(aClass -> {
            Module module = new Module();

            TsComponent component = aClass.getAnnotation(TsComponent.class);
            Class<?> clazz = component.value();
            if (!clazz.isAnnotationPresent(TsModel.class)) {
                throw new RuntimeException();
            }
            Model model = getModel(clazz);
            module.setNome(model.getNome());

            module.addProvider(serviceConverter.getService(aClass));
            module.addDeclaration(componentConverter.getComponent(aClass));

            if (component.crud()) {
                module.setCrud(true);
            }

            modules.add(module);
        });

        return modules;
    }
}
