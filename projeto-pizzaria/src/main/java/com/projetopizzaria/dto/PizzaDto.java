package com.projetopizzaria.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PizzaDto {

    private Long idPizza;
    private String nome;
    private BigDecimal precoBase;
    private boolean personalizada;
}
