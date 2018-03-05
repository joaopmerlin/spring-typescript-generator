package com.spring.typescript.generator.mavenplugin.service;

import com.spring.typescript.generator.mavenplugin.model.Model;
import com.spring.typescript.generator.mavenplugin.model.Parametros;
import com.spring.typescript.generator.mavenplugin.model.Service;

import java.util.List;

public class PluginService {

    private ClassService classService = new ClassService();
    private TemplateService templateService = new TemplateService();
    private ConverterService<Model> converterModel = new ConverterModelService();
    private ConverterService<Service> converterController = new ConverterControllerService();

    public void buid(Parametros parametros) {

        List<Model> models = converterModel.converter(classService.getModels());
        models.forEach(model -> templateService.build(model, "model", parametros));

        List<Service> services = converterController.converter(classService.getServices());
        services.forEach(service -> templateService.build(service, "service", parametros));

    }
}
