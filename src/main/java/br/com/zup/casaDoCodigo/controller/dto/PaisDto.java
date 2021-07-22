package br.com.zup.casaDoCodigo.controller.dto;

public class PaisDto {
    private String nome;

    public PaisDto(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
