package com.projetopizzaria.dto;

import jakarta.persistence.GeneratedValue;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FornadaDto {
    private Long idFornada;
    private int numFornada;
    private int qtdPizzas;
}
