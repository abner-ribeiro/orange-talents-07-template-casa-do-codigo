package br.com.zup.casaDoCodigo.controller.form;

import br.com.zup.casaDoCodigo.controller.validator.CpfCnpj;
import br.com.zup.casaDoCodigo.controller.validator.IdExists;
import br.com.zup.casaDoCodigo.controller.validator.StateExists;
import br.com.zup.casaDoCodigo.controller.validator.UniqueValue;
import br.com.zup.casaDoCodigo.modelo.Cliente;
import br.com.zup.casaDoCodigo.modelo.Estado;
import br.com.zup.casaDoCodigo.modelo.Pais;
import br.com.zup.casaDoCodigo.repository.EstadoRepository;
import br.com.zup.casaDoCodigo.repository.PaisRepository;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@StateExists
public class ClienteForm {
    @NotBlank
    @Email
    @UniqueValue(domainClass = Cliente.class, fieldName = "email")
    private String email;
    @NotBlank
    private String nome;
    @NotBlank
    private String sobrenome;
    @NotBlank @CpfCnpj @UniqueValue(domainClass = Cliente.class, fieldName = "documento")
    private String documento;
    @NotBlank
    private String endereco;
    @NotBlank
    private String complemento;
    @NotBlank
    private String cidade;
    @NotNull @IdExists(domainClass = Pais.class, fieldName = "id")
    private Long paisId;
    @IdExists(domainClass = Estado.class, fieldName = "id")
    private Long estadoId;
    @NotNull
    private Integer telefone;
    @NotBlank
    private String cep;

    public ClienteForm(String email, String nome, String sobrenome, String documento, String endereco, String complemento, String cidade, Long paisId, Long estadoId, Integer telefone, String cep) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.paisId = paisId;
        this.estadoId = estadoId;
        this.telefone = telefone;
        this.cep = cep;
    }

    public Cliente toModel(PaisRepository paisRepository, EstadoRepository estadoRepository){
        @NotNull Pais pais = paisRepository.findById(paisId).get();

        if(estadoId == null){
            return new Cliente(email, nome, sobrenome, documento, endereco, complemento, cidade, pais, telefone, cep);
        }else{
            Estado estado = estadoRepository.findById(estadoId).get();
            return new Cliente(email, nome, sobrenome, documento, endereco, complemento, cidade, pais, estado, telefone, cep);
        }

    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getDocumento() {
        return documento;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public Long getPaisId() {
        return paisId;
    }

    public Long getEstadoId() {
        return estadoId;
    }

    public Integer getTelefone() {
        return telefone;
    }

    public String getCep() {
        return cep;
    }
}
