package com.projetopizzaria.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BebidaDto {
    private Long idBebida;
    private String nome;
    private BigDecimal preco;
}
