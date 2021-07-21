package br.com.zup.casaDoCodigo.controller.dto;

public class CategoriaDto {
    private String nome;

    public CategoriaDto(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
