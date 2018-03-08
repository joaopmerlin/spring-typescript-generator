package com.spring.typescript.generator.samplemaven.model;

import com.spring.typescript.generator.annotation.TsIgnore;
import com.spring.typescript.generator.annotation.TsModel;

import java.util.Date;

/**
 * Created by joao on 17/08/17.
 */

@TsModel(value = "user", encapsulate = false)
public class User extends SuperUser {

    @TsIgnore
    private String email;
    private Date cadastro;
    private Boolean ativo;
    private Grupo grupo;
}
