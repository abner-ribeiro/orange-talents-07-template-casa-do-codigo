package br.com.zup.casaDoCodigo.controller.dto;

public class ClienteDto {
    private Long id;

    public ClienteDto(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
