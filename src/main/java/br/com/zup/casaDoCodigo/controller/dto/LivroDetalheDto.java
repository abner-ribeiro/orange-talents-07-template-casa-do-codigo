package br.com.zup.casaDoCodigo.controller.dto;

import br.com.zup.casaDoCodigo.modelo.Autor;
import br.com.zup.casaDoCodigo.modelo.Livro;

import java.math.BigDecimal;

public class LivroDetalheDto {
    private String titulo;
    private String resumo;
    private String sumario;
    private BigDecimal preco;
    private Integer numeroDePaginas;
    private String isbn;
    private String autor;

    public LivroDetalheDto(Livro livro) {
        this.titulo = livro.getTitulo();
        this.resumo = livro.getResumo();
        this.sumario = livro.getSumario();
        this.preco = livro.getPreco();
        this.numeroDePaginas = livro.getNumeroDePaginas();
        this.isbn = livro.getIsbn();
        this.autor = livro.getAutor().getNome();
    }

    public String getTitulo() {
        return titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public Integer getNumeroDePaginas() {
        return numeroDePaginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getAutor() {
        return autor;
    }
}
