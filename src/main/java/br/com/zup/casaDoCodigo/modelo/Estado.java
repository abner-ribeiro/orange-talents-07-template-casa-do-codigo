package br.com.zup.casaDoCodigo.modelo;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Estado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;
    @ManyToOne
    private Pais pais;

    @Deprecated
    public Estado() {
    }

    public Estado(String nome, Pais pais) {
        this.nome = nome;
        this.pais = pais;
    }

    public String getNome() {
        return this.nome;
    }

    public Pais getPais() {
        return pais;
    }
}
