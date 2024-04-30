package com.projetopizzaria.controllers;

import com.projetopizzaria.dto.ClienteDto;
import com.projetopizzaria.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<ClienteDto> cadastrarCliente(@RequestBody ClienteDto clienteDto){
        clienteService.cadastrarCliente(clienteDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ClienteDto> buscarClientePorId(@PathVariable Long id){
        ClienteDto clienteDto = clienteService.buscarClientePorId(id);
        return ResponseEntity.status(HttpStatus.OK).body(clienteDto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ClienteDto> atualizarCliente(@PathVariable Long id, @RequestBody ClienteDto clienteDto){
        clienteService.atualizarCliente(clienteDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletarCliente(@PathVariable Long id){
        clienteService.deletarCliente(id);
        return ResponseEntity.noContent().build();
    }

}
