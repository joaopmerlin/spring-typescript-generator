package com.spring.typescript.generator.mavenplugin.model;

import com.spring.typescript.generator.mavenplugin.enumeration.TipoComponente;

public class Atributo {

    private String nome;

    private String tipo;

    private Boolean body = false;

    private Boolean param = false;

    private Boolean disabled = false;

    private TipoComponente tipoComponente;

    private Boolean relationShip = false;

    private String relationShipLabel;

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

    public Boolean getDisabled() {
        return disabled;
    }

    public void setDisabled(Boolean disabled) {
        this.disabled = disabled;
    }

    public TipoComponente getTipoComponente() {
        return tipoComponente;
    }

    public void setTipoComponente(TipoComponente tipoComponente) {
        this.tipoComponente = tipoComponente;
    }

    public Boolean getRelationShip() {
        return relationShip;
    }

    public void setRelationShip(Boolean relationShip) {
        this.relationShip = relationShip;
    }

    public String getRelationShipLabel() {
        return relationShipLabel;
    }

    public void setRelationShipLabel(String relationShipLabel) {
        this.relationShipLabel = relationShipLabel;
    }
}
