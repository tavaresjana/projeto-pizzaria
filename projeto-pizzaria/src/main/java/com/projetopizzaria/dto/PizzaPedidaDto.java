package com.projetopizzaria.dto;

import com.projetopizzaria.models.Pedido;
import com.projetopizzaria.models.Pizza;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PizzaPedidaDto {

    private Long idPizzaPedida;
    private Pedido pedido;
    private Pizza pizza;
    @Column(nullable = false)
    private int quantidade;
}
