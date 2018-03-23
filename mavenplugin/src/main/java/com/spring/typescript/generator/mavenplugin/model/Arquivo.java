package com.spring.typescript.generator.mavenplugin.model;

public interface Arquivo {

    String getNome();

    String getNomeArquivo();

    String getFolder();

    String getExtensao();

    void addImport(Model model);
}
