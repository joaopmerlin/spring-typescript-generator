package com.spring.typescript.generator.mavenplugin.model;

import java.util.LinkedHashSet;
import java.util.Set;

public interface Arquivo {

    Set<Model> imports = new LinkedHashSet<>();

    default Set<Model> getImports() {
        return imports;
    }

    default void addImport(Model model) {
        this.imports.add(model);
    }

    String getNomeArquivo();
}
