package com.spring.typescript.generator.mavenplugin.model;

import java.beans.Introspector;
import java.util.LinkedHashSet;
import java.util.Set;

public class Service implements Arquivo {

    private String nome;

    private Set<Metodo> metodos = new LinkedHashSet<>();

    private Set<Model> imports = new LinkedHashSet<>();

    public String getNome() {
        return nome + "Service";
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeArquivo() {
        return nome.toLowerCase() + ".service";
    }

    public String getFolder() {
        return nome.toLowerCase();
    }

    public Set<Metodo> getMetodos() {
        return metodos;
    }

    public void addMetodo(Metodo metodo) {
        this.metodos.add(metodo);
    }

    public Set<Model> getImports() {
        return imports;
    }

    public void addImport(Model model) {
        if (this.imports.stream().filter(e -> e.getNome().equals(model.getNome())).count() == 0) {
            this.imports.add(model);
        }
    }

    public String getNomeLower() {
        return Introspector.decapitalize(getNome());
    }
}
