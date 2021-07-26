package br.com.zup.casaDoCodigo.controller;

import br.com.zup.casaDoCodigo.controller.dto.ClienteDto;
import br.com.zup.casaDoCodigo.controller.dto.EstadoDto;
import br.com.zup.casaDoCodigo.controller.form.ClienteForm;
import br.com.zup.casaDoCodigo.modelo.Cliente;
import br.com.zup.casaDoCodigo.repository.ClienteRepository;
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

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    ClienteRepository clienteRepository;
    @Autowired
    PaisRepository paisRepository;
    @Autowired
    EstadoRepository estadoRepository;

    @PostMapping
    public ResponseEntity<ClienteDto> cadastrar(@RequestBody @Valid ClienteForm clienteForm){
        Cliente cliente = clienteForm.toModel(paisRepository,estadoRepository);
        clienteRepository.save(cliente);
        return ResponseEntity.status(HttpStatus.OK).body(new ClienteDto(cliente.getId()));
    }
}
