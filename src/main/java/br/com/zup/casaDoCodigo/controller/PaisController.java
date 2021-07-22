package br.com.zup.casaDoCodigo.controller;

import br.com.zup.casaDoCodigo.controller.dto.PaisDto;
import br.com.zup.casaDoCodigo.controller.form.PaisForm;
import br.com.zup.casaDoCodigo.modelo.Pais;
import br.com.zup.casaDoCodigo.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/paises")
public class PaisController {
    @Autowired
    PaisRepository paisRepository;

    @PostMapping
    public ResponseEntity<PaisDto> cadastrar(@RequestBody @Valid PaisForm paisForm){
        Pais pais = paisForm.toModel();
        paisRepository.save(pais);
        return ResponseEntity.status(HttpStatus.OK).body(new PaisDto(pais.getNome()));
    }
}
