package com.spring.typescript.generator.mavenplugin.model;

import java.util.List;

public class Metodo {

    private String nome;

    private String retorno;

    private List<Model> parametros;

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

    public List<Model> getParametros() {
        return parametros;
    }

    public void addParametro(Model parametro) {
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
}
