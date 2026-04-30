package com.academia.facens.dto.request;

public class PlanoRequest {

    private String nome;
    private Double valor;

    public String getNome() {
        return nome;
    }

    public Double getValor() {
        return valor;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}