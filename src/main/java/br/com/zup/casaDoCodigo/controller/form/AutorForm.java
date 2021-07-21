package br.com.zup.casaDoCodigo.controller.form;

import br.com.zup.casaDoCodigo.controller.validator.UniqueValue;
import br.com.zup.casaDoCodigo.modelo.Autor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AutorForm {
    @NotBlank
    private String nome;
    @NotBlank @Email @UniqueValue(domainClass = Autor.class, fieldName = "email")
    private String email;
    @NotBlank @Size(max=400)
    private String descricao;

    public Autor toModel(){
        return new Autor(nome,email,descricao);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
