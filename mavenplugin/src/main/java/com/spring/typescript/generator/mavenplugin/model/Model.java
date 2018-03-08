package com.spring.typescript.generator.mavenplugin.model;

import java.util.LinkedHashSet;
import java.util.Set;

public class Model implements Arquivo {

    private String nome;

    private String nomeArquivo;

    private Set<Atributo> atributos = new LinkedHashSet<>();

    private Set<Model> imports = new LinkedHashSet<>();

    private Boolean encapsular;

    private String modifier;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeArquivo() {
        return nomeArquivo == null ? nome.toLowerCase() : nomeArquivo;
    }

    public void setNomeArquivo(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    public Set<Atributo> getAtributos() {
        return atributos;
    }

    public void addAtributo(Atributo atributo) {
        this.atributos.add(atributo);
    }

    public Set<Model> getImports() {
        return imports;
    }

    public void addImport(Model model) {
        this.imports.add(model);
    }

    public Boolean getEncapsular() {
        return encapsular;
    }

    public void setEncapsular(Boolean encapsular) {
        this.encapsular = encapsular;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }
}
