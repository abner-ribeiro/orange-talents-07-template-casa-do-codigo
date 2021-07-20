package br.com.zup.casaDoCodigo.controller.form;

import br.com.zup.casaDoCodigo.modelo.Autor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AutorForm {
    @NotBlank
    public String nome;
    @NotBlank @Email
    public String email;
    @NotBlank @Size(max=400)
    public String descricao;

    public Autor toModel(){
        return new Autor(nome,email,descricao);
    }
}
