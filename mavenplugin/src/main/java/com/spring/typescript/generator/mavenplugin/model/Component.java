package com.spring.typescript.generator.mavenplugin.model;

public class Component implements Arquivo {

    private String nome;

    private Service service;

    @Override
    public String getNome() {
        return nome + "Component";
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String getNomeArquivo() {
        return nome.toLowerCase() + ".component";
    }

    @Override
    public String getFolder() {
        return nome.toLowerCase();
    }

    @Override
    public void addImport(Model model) {

    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }
}
