package com.academia.facens.dto;

public class PlanoResponse {

    private Long id;
    private String nome;
    private Double valor;

    public PlanoResponse(Long id, String nome, Double valor) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Double getValor() {
        return valor;
    }
}