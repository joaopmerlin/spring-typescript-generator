package com.spring.typescript.generator.mavenplugin.model;

public class Html implements Arquivo {

    private String nome;

    @Override
    public String getNome() {
        return nome;
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
    public String getExtensao() {
        return "html";
    }

    @Override
    public void addImport(Model model) {

    }
}
