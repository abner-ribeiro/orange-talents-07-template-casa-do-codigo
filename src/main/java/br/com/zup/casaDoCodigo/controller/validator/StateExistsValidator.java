package br.com.zup.casaDoCodigo.controller.validator;

import br.com.zup.casaDoCodigo.controller.form.ClienteForm;
import br.com.zup.casaDoCodigo.modelo.Estado;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class StateExistsValidator implements ConstraintValidator<StateExists, ClienteForm> {
    @PersistenceContext
    private EntityManager manager;

    @Override
    public boolean isValid(ClienteForm clienteForm, ConstraintValidatorContext constraintValidatorContext) {
        Query query = manager.createQuery("select 1 from Estado where pais_id=:value");
        query.setParameter("value", clienteForm.getPaisId());
        List<Estado> list = query.getResultList();
        return (list.isEmpty() && (clienteForm.getEstadoId() == null)) || ((!list.isEmpty()) && (clienteForm.getEstadoId() != null));
    }
}
