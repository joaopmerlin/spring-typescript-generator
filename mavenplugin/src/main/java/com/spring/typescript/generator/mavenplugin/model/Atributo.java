package com.spring.typescript.generator.mavenplugin.model;

public class Atributo {

    private String nome;

    private String tipo;

    private Boolean body = false;

    private Boolean param = false;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Boolean getBody() {
        return body;
    }

    public void setBody(Boolean body) {
        this.body = body;
    }

    public Boolean getParam() {
        return param;
    }

    public void setParam(Boolean param) {
        this.param = param;
    }
}
