package br.com.zup.casaDoCodigo.controller.form;

import br.com.zup.casaDoCodigo.controller.validator.UniqueValue;
import br.com.zup.casaDoCodigo.modelo.Categoria;

import javax.validation.constraints.NotBlank;

public class CategoriaForm {
    @NotBlank @UniqueValue(domainClass = Categoria.class, fieldName = "nome")
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
