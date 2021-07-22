package br.com.zup.casaDoCodigo.controller;

import br.com.zup.casaDoCodigo.controller.dto.CategoriaDto;
import br.com.zup.casaDoCodigo.controller.form.CategoriaForm;
import br.com.zup.casaDoCodigo.modelo.Categoria;
import br.com.zup.casaDoCodigo.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaController {

    @Autowired
    CategoriaRepository categoriaRepository;

    @PostMapping
    public ResponseEntity<CategoriaDto> cadastrar(@RequestBody @Valid CategoriaForm categoriaForm){
        Categoria categoria = categoriaForm.toModel();
        categoriaRepository.save(categoria);
        return ResponseEntity.status(HttpStatus.OK).body(categoria.toDto());
    }

}
