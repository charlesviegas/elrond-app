package com.elrond.entity;


import javax.persistence.*;
import java.io.Serializable;

@Entity
public class UsuarioPerfil implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Usuario usuario;

    private String perfil;

    public UsuarioPerfil() {
    }

    public UsuarioPerfil(Usuario usuario, String perfil) {
        this.usuario = usuario;
        this.perfil = perfil;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsuarioPerfil that = (UsuarioPerfil) o;

        if (!id.equals(that.id)) return false;
        if (!usuario.equals(that.usuario)) return false;
        return perfil.equals(that.perfil);

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + usuario.hashCode();
        result = 31 * result + perfil.hashCode();
        return result;
    }
}
