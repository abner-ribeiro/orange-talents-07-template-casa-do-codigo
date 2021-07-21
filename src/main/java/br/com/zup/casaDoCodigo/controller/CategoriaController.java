package br.com.zup.casaDoCodigo.controller;

import br.com.zup.casaDoCodigo.controller.dto.CategoriaDto;
import br.com.zup.casaDoCodigo.controller.form.CategoriaForm;
import br.com.zup.casaDoCodigo.controller.validator.NomeDuplicadoCategoriaValidator;
import br.com.zup.casaDoCodigo.modelo.Categoria;
import br.com.zup.casaDoCodigo.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/categoria")
public class CategoriaController {

    @Autowired
    CategoriaRepository categoriaRepository;

    @Autowired
    NomeDuplicadoCategoriaValidator nomeDuplicadoCategoriaValidator;

    @InitBinder
    public void init(WebDataBinder binder){ binder.addValidators(nomeDuplicadoCategoriaValidator); }

    @PostMapping
    public ResponseEntity<CategoriaDto> cadastrar(@RequestBody @Valid CategoriaForm categoriaForm){
        Categoria categoria = categoriaForm.toModel();
        categoriaRepository.save(categoria);
        return ResponseEntity.status(HttpStatus.CREATED).body(categoria.toDto());
    }

}
