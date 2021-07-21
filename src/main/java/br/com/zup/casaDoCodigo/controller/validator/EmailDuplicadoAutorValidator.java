package br.com.zup.casaDoCodigo.controller.validator;

import br.com.zup.casaDoCodigo.controller.form.AutorForm;
import br.com.zup.casaDoCodigo.modelo.Autor;
import br.com.zup.casaDoCodigo.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;


@Component
public class EmailDuplicadoAutorValidator implements Validator {

    @Autowired
    AutorRepository autorRepository;

    @Override
    public boolean supports(Class<?> aClass) {
        return AutorForm.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        if(errors.hasErrors()){
            return;
        }

        AutorForm request = (AutorForm) o;
        Optional<Autor> autor = autorRepository.findByEmail(request.getEmail());

        if(autor.isPresent()){
            errors.rejectValue("email",null,"Já existe um autor com esse email cadastrado "+request.getEmail());
        }
    }
}
