package com.academia.facens.dto;

public class AlunoResponse {

    private Long id;
    private String nome;
    private String email;
    private String nomePlano;

    public AlunoResponse(Long id, String nome, String email, String nomePlano) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.nomePlano = nomePlano;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getNomePlano() {
        return nomePlano;
    }
}