package br.com.zup.casaDoCodigo.controller.dto;

import br.com.zup.casaDoCodigo.modelo.Livro;
import org.springframework.data.domain.Page;

import java.time.LocalDate;
import java.util.stream.Collectors;

public class LivroDto {
    private Long id;
    private String titulo;

    public LivroDto(Long id, String titulo) {
        this.id = id;
        this.titulo = titulo;
    }
    public static Page<LivroDto> pageLivroToPageDto(Page<Livro> livros){
        return livros.map(livro -> new LivroDto(livro.getId(),livro.getTitulo()));
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
