package com.spring.typescript.generator.samplemaven.model;

import com.spring.typescript.generator.annotation.TsModel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by joao on 17/08/17.
 */

@TsModel
@Entity
public class Empresa implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String nome;

    public Empresa(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Empresa() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
