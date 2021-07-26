package br.com.zup.casaDoCodigo.controller.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = {StateExistsValidator.class})
@Target({TYPE})
@Retention(RUNTIME)
public @interface StateExists {
    String message() default "Selecione um estado para o país selecionado!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
