package com.projetopizzaria.controllers;

import com.projetopizzaria.dto.PizzaDto;
import com.projetopizzaria.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/pizzas")
public class PizzaController {

    @Autowired
    private PizzaService pizzaService;

    @GetMapping
    public ResponseEntity<List<PizzaDto>> buscarTodasPizzas() {
        List<PizzaDto> listaPizzasDto = pizzaService.buscarTodasPizzas();
        return ResponseEntity.status(HttpStatus.OK).body(listaPizzasDto);
    }

    @PostMapping
    public ResponseEntity<PizzaDto> cadastrarPizza(@RequestBody PizzaDto pizzaDto){
        pizzaService.cadastrarPizza(pizzaDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PizzaDto> buscarPizzaPorId(@PathVariable Long id){
        PizzaDto pizzaDto = pizzaService.buscarPizzaPorId(id);
        return ResponseEntity.status(HttpStatus.OK).body(pizzaDto);
    }
}
