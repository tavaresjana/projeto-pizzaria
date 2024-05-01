package com.projetopizzaria.controllers;

import com.projetopizzaria.dto.PedidoDto;
import com.projetopizzaria.dto.PizzaPedidaDto;
import com.projetopizzaria.service.PedidoService;
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
@RequestMapping(value = "/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    public ResponseEntity<PedidoDto> cadastrarPedido(@RequestBody PedidoDto pedidoDto){
        pedidoService.cadastrarPedido(pedidoDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PedidoDto> buscarPedidoPorId(@PathVariable Long id){
        PedidoDto pedidoDto = pedidoService.buscarPedidoPorId(id);
        return ResponseEntity.status(HttpStatus.OK).body(pedidoDto);
    }

    /*@PutMapping(value = "/{id}")
    public ResponseEntity<PedidoDto> atualizarPedido(@PathVariable Long id, @RequestBody PedidoDto pedidoDto){
        pedidoService.atualizarPedido(pedidoDto);
        return ResponseEntity.ok().build();
    }*/
}
