package com.spring.typescript.generator.samplemaven.model;

import com.spring.typescript.generator.annotation.TsModel;

import java.io.Serializable;

/**
 * Created by joao on 17/08/17.
 */

@TsModel(value = "super.user", encapsulate = false)
public abstract class SuperUser implements Serializable {

    private Long id;
    private String name;
}
