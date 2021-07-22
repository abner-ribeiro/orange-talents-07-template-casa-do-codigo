package br.com.zup.casaDoCodigo.controller.form;

import br.com.zup.casaDoCodigo.controller.validator.IdExists;
import br.com.zup.casaDoCodigo.controller.validator.UniqueValue;
import br.com.zup.casaDoCodigo.modelo.Autor;
import br.com.zup.casaDoCodigo.modelo.Categoria;
import br.com.zup.casaDoCodigo.modelo.Livro;
import br.com.zup.casaDoCodigo.repository.AutorRepository;
import br.com.zup.casaDoCodigo.repository.CategoriaRepository;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class LivroForm {
    @NotBlank @UniqueValue(domainClass = Livro.class, fieldName = "titulo")
    private String titulo;
    @NotBlank @Size(max = 500)
    private String resumo;
    @NotBlank
    private String sumario;
    @NotNull
    @Min(value = 20)
    private BigDecimal preco;
    @NotNull @Min(value = 100)
    private Integer numeroDePaginas;
    @NotBlank
    private String isbn;
    @Future
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataDePublicacao;
    @NotNull @IdExists(domainClass = Categoria.class, fieldName = "id")
    private Long categoriaId;
    @NotNull @IdExists(domainClass = Autor.class, fieldName = "id")
    private Long autorId;

    public LivroForm(String titulo,
                     String resumo,
                     String sumario,
                     BigDecimal preco,
                     Integer numeroDePaginas,
                     String isbn,
                     Long categoriaId,
                     Long autorId) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numeroDePaginas = numeroDePaginas;
        this.isbn = isbn;
        this.categoriaId = categoriaId;
        this.autorId = autorId;
    }

    public void setDataDePublicacao(LocalDate dataDePublicacao) {
        this.dataDePublicacao = dataDePublicacao;
    }

    public Livro toModel(CategoriaRepository categoriaRepository, AutorRepository autorRepository){
        @NotNull Categoria categoria = categoriaRepository.findById(categoriaId).get();
        @NotNull Autor autor = autorRepository.findById(autorId).get();
        return new Livro(titulo,resumo,sumario,preco,numeroDePaginas,isbn,dataDePublicacao,categoria,autor);
    }
}
