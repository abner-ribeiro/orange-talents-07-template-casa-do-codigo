package br.com.zup.casaDoCodigo.controller.dto;

import br.com.zup.casaDoCodigo.modelo.Autor;

import java.time.LocalDateTime;

public class AutorDto {
    private String nome;
    private String email;
    private String descricao;
    private LocalDateTime dataCriacao;

    public AutorDto(String nome, String email, String descricao, LocalDateTime dataCriacao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
        this.dataCriacao = dataCriacao;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }
}
