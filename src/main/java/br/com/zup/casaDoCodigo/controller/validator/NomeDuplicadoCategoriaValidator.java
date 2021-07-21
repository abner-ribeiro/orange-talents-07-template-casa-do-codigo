package br.com.zup.casaDoCodigo.controller.validator;

import br.com.zup.casaDoCodigo.controller.form.AutorForm;
import br.com.zup.casaDoCodigo.controller.form.CategoriaForm;
import br.com.zup.casaDoCodigo.modelo.Autor;
import br.com.zup.casaDoCodigo.modelo.Categoria;
import br.com.zup.casaDoCodigo.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class NomeDuplicadoCategoriaValidator implements Validator {

    @Autowired
    CategoriaRepository categoriaRepository;

    @Override
    public boolean supports(Class<?> aClass) {
        return CategoriaForm.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        if(errors.hasErrors()){
            return;
        }

        CategoriaForm request = (CategoriaForm) o;
        Optional<Categoria> categoria = categoriaRepository.findByNome(request.getNome());

        if(categoria.isPresent()){
            errors.rejectValue("nome",null,"Já existe uma categoria com esse nome cadastrado "+request.getNome());
        }
    }
}
