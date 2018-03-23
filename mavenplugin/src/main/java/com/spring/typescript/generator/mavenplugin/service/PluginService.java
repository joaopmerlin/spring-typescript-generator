package com.spring.typescript.generator.mavenplugin.service;

import com.spring.typescript.generator.mavenplugin.converter.*;
import com.spring.typescript.generator.mavenplugin.model.*;

import java.util.List;

public class PluginService {

    private ClassService classService = new ClassService();
    private TemplateService templateService = new TemplateService();
    private Converter<Model> converterModel = new ModelConverter();
    private Converter<Service> converter = new ServiceConverter();
    private Converter<Component> converterComponent = new ComponentConverter();
    private Converter<Module> converterModule = new ModuleConverter();

    public void buid(Parametros parametros) {

        List<Model> models = converterModel.converter(classService.getModels());
        models.forEach(model -> templateService.build(model, "model", model.getFolder(), parametros));

        List<Service> services = converter.converter(classService.getComponents());
        services.forEach(service -> templateService.build(service, "service", service.getFolder(), parametros));

        List<Component> components = converterComponent.converter(classService.getComponents());
        components.forEach(component -> templateService.build(component, "component", component.getFolder(), parametros));

        List<Module> modules = converterModule.converter(classService.getComponents());
        modules.forEach(module -> templateService.build(module, "module", module.getFolder(), parametros));

    }
}
