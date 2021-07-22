package br.com.zup.casaDoCodigo.controller;

import br.com.zup.casaDoCodigo.controller.dto.LivroDto;
import br.com.zup.casaDoCodigo.controller.form.LivroForm;
import br.com.zup.casaDoCodigo.modelo.Livro;
import br.com.zup.casaDoCodigo.repository.AutorRepository;
import br.com.zup.casaDoCodigo.repository.CategoriaRepository;
import br.com.zup.casaDoCodigo.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/livros")
public class LivroController {
    @Autowired
    LivroRepository livroRepository;
    @Autowired
    CategoriaRepository categoriaRepository;
    @Autowired
    AutorRepository autorRepository;

    @PostMapping
    public ResponseEntity<LivroDto> cadastrar(@RequestBody @Valid LivroForm livroForm){
        Livro livro = livroForm.toModel(categoriaRepository,autorRepository);
        livroRepository.save(livro);
        return ResponseEntity.status(HttpStatus.OK).body(livro.toDto());
    }

}
