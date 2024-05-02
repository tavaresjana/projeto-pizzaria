package com.projetopizzaria.controllers;

import com.projetopizzaria.dto.FornadaDto;
import com.projetopizzaria.service.FornadaService;
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
@RequestMapping(value = "/fornadas")
public class FornadaController {

    @Autowired
    private FornadaService fornadaService;

    @PostMapping
    public ResponseEntity<FornadaDto> cadastrarFornada(@RequestBody FornadaDto fornadaDto){
        fornadaService.cadastrarFornada(fornadaDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<FornadaDto> buscarFornadaPorId(@PathVariable Long id){
        FornadaDto fornadaDto = fornadaService.buscarFornadaPorId(id);
        return ResponseEntity.status(HttpStatus.OK).body(fornadaDto);
    }

    @GetMapping(value = "/fornadas/numFornada/{numFornada}")
    public ResponseEntity<FornadaDto> buscarPorNumFornada(@PathVariable int numFornada) {
        FornadaDto produtoDto = fornadaService.buscarPorNumFornada(numFornada);
        return ResponseEntity.status(HttpStatus.FOUND).body(produtoDto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<FornadaDto> atualizarFornada(@PathVariable Long id, @RequestBody FornadaDto fornadaDto){
        fornadaService.atualizarFornada(id, fornadaDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletarFornada(@PathVariable Long id){
        fornadaService.deletarFornada(id);
        return ResponseEntity.noContent().build();
    }


}
