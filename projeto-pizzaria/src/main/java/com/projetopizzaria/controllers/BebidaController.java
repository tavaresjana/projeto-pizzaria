package com.projetopizzaria.controllers;

import com.projetopizzaria.dto.BebidaDto;
import com.projetopizzaria.service.BebidaService;
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
@RequestMapping(value = "/bebidas")
public class BebidaController {

    @Autowired
    private BebidaService bebidaService;

    @PostMapping
    public ResponseEntity<BebidaDto> cadastrarBebida(@RequestBody BebidaDto bebidaDto){
        bebidaService.cadastrarBebida(bebidaDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<BebidaDto> buscarBebidaPorId(@PathVariable Long id){
        BebidaDto bebidaDto = bebidaService.buscarBebidaPorId(id);
        return ResponseEntity.status(HttpStatus.OK).body(bebidaDto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<BebidaDto> atualizarBebida(@PathVariable Long id, @RequestBody BebidaDto bebidaDto){
        bebidaService.atualizarBebida(bebidaDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletarBebida(@PathVariable Long id){
        bebidaService.deletarBebida(id);
        return ResponseEntity.noContent().build();
    }
}
