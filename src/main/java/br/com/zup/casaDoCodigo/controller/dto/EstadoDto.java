package br.com.zup.casaDoCodigo.controller.dto;

import br.com.zup.casaDoCodigo.modelo.Estado;

public class EstadoDto {
    public String nome;

    public EstadoDto(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
