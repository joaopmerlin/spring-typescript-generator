package com.spring.typescript.generator.mavenplugin.model;

public interface Arquivo {

    String getNome();

    String getNomeArquivo();

    String getFolder();

    void addImport(Model model);
}
