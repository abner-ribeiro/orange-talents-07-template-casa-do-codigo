package br.com.zup.casaDoCodigo.modelo;

import br.com.zup.casaDoCodigo.controller.dto.CategoriaDto;

import javax.persistence.*;

@Entity
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String nome;

    @Deprecated
    public Categoria(){
    }

    public Categoria(String nome) {
        this.nome = nome;
    }

    public CategoriaDto toDto(){
        return new CategoriaDto(nome);
    }
}
