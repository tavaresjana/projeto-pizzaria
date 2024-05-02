package com.projetopizzaria.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PizzaPedidaDto {

    private Long idPizzaPedida;
    private PedidoDto pedido;
    private PizzaDto pizza;
    @Column(nullable = false)
    private int quantidade;
}
