package com.spring.typescript.generator.mavenplugin.model;

import java.beans.Introspector;
import java.util.LinkedHashSet;
import java.util.Set;

public class Model implements Arquivo {

    private String nome;

    private Set<Atributo> atributos = new LinkedHashSet<>();

    private Set<Model> imports = new LinkedHashSet<>();

    private String modifier;

    public Model() {
    }

    public Model(String nome) {
        this.nome = nome;
    }

    @Override
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String getNomeArquivo() {
        return nome.toLowerCase();
    }

    @Override
    public String getFolder() {
        return nome.toLowerCase();
    }

    @Override
    public String getExtensao() {
        return "ts";
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

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    public String getNomeLower() {
        return Introspector.decapitalize(getNome());
    }
}
