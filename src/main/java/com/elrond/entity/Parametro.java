package com.elrond.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
public class Parametro implements Serializable{

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(max = 100)
    private String nome;

    @NotNull
    @Size(max = 250)
    private String valor;

    private String descricao;

    public Parametro() {
    }

    public Parametro(String nome, String valor, String descricao) {
        this.nome = nome;
        this.valor = valor;
        this.descricao = descricao;
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

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Parametro parametro = (Parametro) o;

        if (id != null ? !id.equals(parametro.id) : parametro.id != null) return false;
        if (nome != null ? !nome.equals(parametro.nome) : parametro.nome != null) return false;
        if (valor != null ? !valor.equals(parametro.valor) : parametro.valor != null) return false;
        return descricao != null ? descricao.equals(parametro.descricao) : parametro.descricao == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        result = 31 * result + (valor != null ? valor.hashCode() : 0);
        result = 31 * result + (descricao != null ? descricao.hashCode() : 0);
        return result;
    }
}
