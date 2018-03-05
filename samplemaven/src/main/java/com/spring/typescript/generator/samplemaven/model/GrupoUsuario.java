package com.spring.typescript.generator.samplemaven.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.spring.typescript.generator.annotation.TsIgnore;
import com.spring.typescript.generator.annotation.TsModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by vinicius.ferrarini on 21/06/2016.
 */
@Entity
@Table(name = "oriongrupousuario")
@SequenceGenerator(name = "seq_orion", sequenceName = "seq_orion", allocationSize = 1)
@Data
@NoArgsConstructor
@AllArgsConstructor
@TsModel
public class GrupoUsuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_orion")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario")
    @JsonBackReference
    @TsIgnore
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "grupo")
    private Grupo grupo;

    public GrupoUsuario(Usuario usuario, Grupo grupo) {
        this.usuario = usuario;
        this.grupo = grupo;
    }
}
