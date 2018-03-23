package com.spring.typescript.generator.mavenplugin.model;

import java.util.LinkedHashSet;
import java.util.Set;

public class Module implements Arquivo {

    private String nome;

    private Set<Component> declarations = new LinkedHashSet<>();

    private Set<Service> providers = new LinkedHashSet<>();

    @Override
    public String getNome() {
        return nome + "Module";
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String getNomeArquivo() {
        return nome.toLowerCase() + ".module";
    }

    @Override
    public String getFolder() {
        return nome.toLowerCase();
    }

    @Override
    public void addImport(Model model) {

    }

    public void addProvider(Service service) {
        providers.add(service);
    }

    public Set<Service> getProviders() {
        return providers;
    }

    public void addDeclaration(Component component) {
        declarations.add(component);
    }

    public Set<Component> getDeclarations() {
        return declarations;
    }
}
