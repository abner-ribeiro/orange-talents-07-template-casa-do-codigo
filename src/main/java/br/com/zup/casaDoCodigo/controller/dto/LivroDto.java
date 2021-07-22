package br.com.zup.casaDoCodigo.controller.dto;

import java.time.LocalDate;

public class LivroDto {
    private Long id;
    private String titulo;

    public LivroDto(Long id, String titulo) {
        this.id = id;
        this.titulo = titulo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
