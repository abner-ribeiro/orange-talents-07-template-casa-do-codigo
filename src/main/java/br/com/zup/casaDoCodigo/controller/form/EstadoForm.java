package br.com.zup.casaDoCodigo.controller.form;

import br.com.zup.casaDoCodigo.controller.validator.IdExists;
import br.com.zup.casaDoCodigo.modelo.Estado;
import br.com.zup.casaDoCodigo.modelo.Pais;
import br.com.zup.casaDoCodigo.repository.PaisRepository;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class EstadoForm {
    @NotBlank
    private String nome;
    @NotNull @IdExists(domainClass = Pais.class, fieldName = "id")
    private Long paisId;

    public Estado toModel(PaisRepository paisRepository){
        @NotNull Pais pais = paisRepository.findById(paisId).get();

        return new Estado(nome, pais);
    }

    public String getNome() {
        return nome;
    }

    public Long getPaisId() {
        return paisId;
    }
}
