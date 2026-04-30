package com.academia.facens.dto.request;

public class AlunoRequest {

    private String nome;
    private String email;
    private Long planoId;

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public Long getPlanoId() {
        return planoId;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPlanoId(Long planoId) {
        this.planoId = planoId;
    }
}