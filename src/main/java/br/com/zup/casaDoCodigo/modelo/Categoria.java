package br.com.zup.casaDoCodigo.modelo;

import br.com.zup.casaDoCodigo.controller.dto.CategoriaDto;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank @Column(unique = true)
    private String nome;

    @Deprecated
    public Categoria(){
    }

    public Categoria(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
