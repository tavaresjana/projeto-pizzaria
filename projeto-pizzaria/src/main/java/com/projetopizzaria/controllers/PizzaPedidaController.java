package com.projetopizzaria.controllers;

import com.projetopizzaria.dto.PizzaPedidaDto;
import com.projetopizzaria.service.PizzaPedidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/pizzaspedidas")
public class PizzaPedidaController {

    @Autowired
    private PizzaPedidaService pizzaPedidaService;

    @PostMapping
    public ResponseEntity<PizzaPedidaDto> cadastrarPizzaPedida(@RequestBody PizzaPedidaDto pizzaPedidaDto) throws Exception {
        pizzaPedidaService.cadastrarPizzaPedida(pizzaPedidaDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PizzaPedidaDto> buscarPizzaPedidaPorId(@PathVariable Long id){
        PizzaPedidaDto pizzaPedidaDto = pizzaPedidaService.buscarPizzaPedidaPorId(id);
        return ResponseEntity.status(HttpStatus.OK).body(pizzaPedidaDto);
    }

    @GetMapping(value = "/total/{id}")
    public ResponseEntity<String> cacularValorTotal(@PathVariable Long id){
        String valorTotal = pizzaPedidaService.cacularValorTotal(id);
        return ResponseEntity.status(HttpStatus.OK).body(valorTotal);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<PizzaPedidaDto> atualizarPizzaPedida(@PathVariable Long id, @RequestBody PizzaPedidaDto pizzaPedidaDto){
        pizzaPedidaService.atualizarPizzaPedida(pizzaPedidaDto);
        return ResponseEntity.ok().build();
    }
}