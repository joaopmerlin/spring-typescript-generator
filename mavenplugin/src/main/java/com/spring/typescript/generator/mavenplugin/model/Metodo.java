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

    private Boolean findAll = false;

    private Boolean findOne = false;

    private Boolean save = false;

    private Boolean delete = false;

    public Metodo(String nome, String retorno, Set<Atributo> parametros, String url, String method) {
        this.nome = nome;
        this.retorno = retorno;
        this.parametros = parametros;
        this.url = url;
        this.method = method;
    }

    public Metodo(String nome, String retorno, String url, String method) {
        this.nome = nome;
        this.retorno = retorno;
        this.url = url;
        this.method = method;
    }

    public Metodo() {
    }

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

    public String getParametrosNomes() {
        return parametros.stream().map(Atributo::getNome).collect(Collectors.joining(", "));
    }

    public Boolean getFindAll() {
        return findAll;
    }

    public void setFindAll(Boolean findAll) {
        this.findAll = findAll;
    }

    public Boolean getSave() {
        return save;
    }

    public void setSave(Boolean save) {
        this.save = save;
    }

    public Boolean getDelete() {
        return delete;
    }

    public void setDelete(Boolean delete) {
        this.delete = delete;
    }

    public Boolean getFindOne() {
        return findOne;
    }

    public void setFindOne(Boolean findOne) {
        this.findOne = findOne;
    }
}
