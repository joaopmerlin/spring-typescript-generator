package com.spring.typescript.generator.mavenplugin.service;

import com.spring.typescript.generator.mavenplugin.model.Arquivo;
import com.spring.typescript.generator.mavenplugin.model.Parametros;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;

import java.io.*;
import java.util.HashMap;

public class TemplateService {

    public void build(Arquivo arquivo, String templateName, String folder, Parametros parametros) {
        try {
            HashMap<String, Object> params = new HashMap<>();
            params.put(templateName, arquivo);

            Configuration cfg = new Configuration(Configuration.VERSION_2_3_26);
            cfg.setDefaultEncoding("UTF-8");
            cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);

            InputStream modelTemplate = getClass().getResourceAsStream(String.format("/%s.ftl", templateName));

            Template template = new Template(null, new InputStreamReader(modelTemplate), cfg);

            String dir = parametros.getDestino() + "/" + folder;
            new File(dir).mkdir();
            File file = new File(dir + String.format("/%s.ts", arquivo.getNomeArquivo()));

            try (Writer writer = new FileWriter(file)) {
                template.process(params, writer);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
