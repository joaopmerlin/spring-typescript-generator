package com.spring.typescript.generator.samplemaven.model;

import com.spring.typescript.generator.annotation.TsIgnore;
import com.spring.typescript.generator.annotation.TsModel;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by joao on 17/08/17.
 */

@TsModel(value = "user", encapsulate = false)
public class User implements Serializable {

    private Long id;
    private String name;
    @TsIgnore
    private String email;
    private Date cadastro;
    private Boolean ativo;
    private Grupo grupo;

    public User(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
}
