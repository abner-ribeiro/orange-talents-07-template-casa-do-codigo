package br.com.zup.casaDoCodigo.controller;

import br.com.zup.casaDoCodigo.controller.dto.AutorDto;
import br.com.zup.casaDoCodigo.controller.form.AutorForm;
import br.com.zup.casaDoCodigo.modelo.Autor;
import br.com.zup.casaDoCodigo.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/autores")
public class AutorController {

    @Autowired
    AutorRepository autorRepository;

    @PostMapping
    public ResponseEntity<AutorDto> cadastrar(@RequestBody @Valid AutorForm autorForm){
        Autor autor = autorForm.toModel();
        autorRepository.save(autor);
        return ResponseEntity.status(HttpStatus.OK).body(new AutorDto(autor.getNome(), autor.getEmail(), autor.getDescricao(), autor.getDataCriacao()));
    }
}
