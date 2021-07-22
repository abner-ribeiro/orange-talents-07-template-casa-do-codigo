package br.com.zup.casaDoCodigo.controller.dto;

import java.time.LocalDate;

public class LivroDto {
    private String titulo;
    private LocalDate dataDePublicacao;
    private String isbn;

    public LivroDto(String titulo, LocalDate dataDePublicacao, String isbn) {
        this.titulo = titulo;
        this.dataDePublicacao = dataDePublicacao;
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public LocalDate getDataDePublicacao() {
        return dataDePublicacao;
    }

    public void setDataDePublicacao(LocalDate dataDePublicacao) {
        this.dataDePublicacao = dataDePublicacao;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
