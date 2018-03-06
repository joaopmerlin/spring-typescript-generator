package com.spring.typescript.generator.mavenplugin.model;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Metodo {

    private String nome;

    private String retorno;

    private Set<Atributo> parametros = new LinkedHashSet<>();

    private String url;

    private String method;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRetorno() {
        return retorno;
    }

    public void setRetorno(String retorno) {
        this.retorno = retorno;
    }

    public Set<Atributo> getParametros() {
        return parametros;
    }

    public void setParametros(Set<Atributo> parametros) {
        this.parametros = parametros;
    }

    public void addParametro(Atributo parametro) {
        this.parametros.add(parametro);
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getParametrosString() {
        return parametros.stream().map(e -> e.getNome() + ": " + e.getTipo()).collect(Collectors.joining(", "));
    }

    public String getParametroBody() {
        List<Atributo> collect = parametros.stream().filter(e -> e.getBody()).collect(Collectors.toList());
        return collect.isEmpty() ? null : collect.get(0).getNome();
    }
}
