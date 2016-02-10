package com.elrond.entity;


public class Parametro {

    private final long id;
    private final String chave;
    private final String valor;

    public Parametro(long id, String chave, String valor) {
        this.id = id;
        this.chave = chave;
        this.valor = valor;
    }

    public long getId() {
        return id;
    }

    public String getChave() {
        return chave;
    }

    public String getValor() {
        return valor;
    }
}
