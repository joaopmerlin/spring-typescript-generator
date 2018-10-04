package com.spring.typescript.generator.samplemaven.model;

import com.spring.typescript.generator.annotation.TsIgnore;
import com.spring.typescript.generator.annotation.TsModel;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * Created by joao on 17/08/17.
 */

@TsModel
@Entity
@Data
public class Grupo implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String nome;

    @ManyToMany
    @TsIgnore
    private Set<Empresa> empresas;
}
