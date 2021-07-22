package br.com.zup.casaDoCodigo.controller.form;

import br.com.zup.casaDoCodigo.controller.validator.UniqueValue;
import br.com.zup.casaDoCodigo.modelo.Pais;

import javax.validation.constraints.NotBlank;

public class PaisForm {
    @NotBlank @UniqueValue(domainClass = Pais.class, fieldName = "nome")
    private String nome;

    public Pais toModel(){
        return new Pais(nome);
    }

    public String getNome() {
        return nome;
    }
}
