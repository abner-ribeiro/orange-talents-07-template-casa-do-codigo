package br.com.zup.casaDoCodigo.modelo;

import br.com.zup.casaDoCodigo.controller.dto.AutorDto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String descricao;

    private LocalDateTime dataCriacao = LocalDateTime.now();

    public Autor(String nome, String email, String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }
    public Autor(){
    }

    public AutorDto toDto(){
        return new AutorDto(nome,email,descricao,dataCriacao);
    }
}
