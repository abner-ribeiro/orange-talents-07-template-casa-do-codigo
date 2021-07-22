package br.com.zup.casaDoCodigo.controller;

import br.com.zup.casaDoCodigo.controller.dto.EstadoDto;
import br.com.zup.casaDoCodigo.controller.form.EstadoForm;
import br.com.zup.casaDoCodigo.modelo.Estado;
import br.com.zup.casaDoCodigo.repository.EstadoRepository;
import br.com.zup.casaDoCodigo.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/estados")
public class EstadoController {
    @Autowired
    EstadoRepository estadoRepository;
    @Autowired
    PaisRepository paisRepository;

    @PostMapping
    public ResponseEntity<EstadoDto> cadastrar(@RequestBody @Valid EstadoForm estadoForm){
        Optional<Estado> estadoRequest = estadoRepository.findByNome(estadoForm.getNome());
        //Verifica se esse estado tem o nome único somente para aquele país que deseja cadastrar
        if(estadoRequest.isPresent() && (estadoRequest.get().getPais().getId() == estadoForm.getPaisId())){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        Estado estado = estadoForm.toModel(paisRepository);
        estadoRepository.save(estado);
        return ResponseEntity.status(HttpStatus.OK).body(new EstadoDto(estado.getNome()));
    }
}
