package com.spring.typescript.generator.samplemaven.model;

import com.spring.typescript.generator.annotation.TsModel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;

/**
 * Created by joao on 17/08/17.
 */

@TsModel("Usuario")
@Entity
public class User {

    @Id
    @GeneratedValue
    private Long id;

    private String email;

    private Date cadastro;

    private Boolean ativo;

    @ManyToOne
    private Grupo grupo;
}
