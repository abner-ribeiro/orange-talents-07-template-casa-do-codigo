package br.com.zup.casaDoCodigo.controller.form;

import br.com.zup.casaDoCodigo.modelo.Categoria;

import javax.validation.constraints.NotBlank;

public class CategoriaForm {
    @NotBlank
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Categoria toModel(){
        return new Categoria(nome);
    }
}
