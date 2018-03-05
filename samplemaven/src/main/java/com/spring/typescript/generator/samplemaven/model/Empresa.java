package com.spring.typescript.generator.samplemaven.model;

import com.spring.typescript.generator.annotation.TsModel;

import java.io.Serializable;

/**
 * Created by joao on 17/08/17.
 */

@TsModel
public class Empresa implements Serializable {

    private Long id;
    private String nome;
}
