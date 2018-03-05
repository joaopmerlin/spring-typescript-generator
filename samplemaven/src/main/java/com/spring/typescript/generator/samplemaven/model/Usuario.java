package com.spring.typescript.generator.samplemaven.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.spring.typescript.generator.annotation.TsModel;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "orionusuario")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@SequenceGenerator(name = "seq_orion", sequenceName = "seq_orion", allocationSize = 1)
@TsModel(encapsulate = false)
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_orion")
    private Long id;

    @Column
    private String nome;

    @Column(name = "login")
    private String usuario;

    @Column
    private String senha;

    @Transient
    private Boolean alteraSenha = false;

    @Fetch(FetchMode.SELECT)
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JsonManagedReference
    private List<GrupoUsuario> grupoUsuarioList;

    @Column
    private Boolean inativo = false;

    @Column
    private String email;

    @Column
    private String foto;

    @Column(name = "paginainicial")
    private String paginaInicial;

    @Column(name = "permissoesgrupo")
    private Boolean permissoesGrupo = true;

    private String tema;

    private String cor;

    @Column(name = "pessoa")
    private Integer pessoaId;

    private String idioma;

    public Usuario(Long id){
        this.id = id;
    }

    public Boolean getPermissoesGrupo(){
        if (permissoesGrupo == null){
            return true;
        }
        return permissoesGrupo;
    }

    public String getCor(){
        if (cor == null){
            cor = "color-blue";
        }
        return cor;
    }

    public String getTema(){
        return tema == null ? "theme-light" : tema;
    }
}
