package br.com.zup.casaDoCodigo.modelo;

import br.com.zup.casaDoCodigo.controller.dto.LivroDto;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank @Column(unique = true)
    private String titulo;
    @NotBlank @Size(max = 500)
    private String resumo;
    @NotBlank
    private String sumario;
    @NotNull @Min(value = 20)
    private BigDecimal preco;
    @NotNull @Min(value = 100)
    private Integer numeroDePaginas;
    @NotBlank
    private String isbn;
    @Future
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataDePublicacao;
    @ManyToOne
    private Categoria categoria;
    @ManyToOne
    private Autor autor;

    public Livro(){
    }

    public Livro(String titulo, String resumo, String sumario, BigDecimal preco, Integer numeroDePaginas, String isbn, LocalDate dataDePublicacao, Categoria categoria, Autor autor) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numeroDePaginas = numeroDePaginas;
        this.isbn = isbn;
        this.dataDePublicacao = dataDePublicacao;
        this.categoria = categoria;
        this.autor = autor;
    }

    public LivroDto toDto(){
        return new LivroDto(id,titulo);
    }
}
