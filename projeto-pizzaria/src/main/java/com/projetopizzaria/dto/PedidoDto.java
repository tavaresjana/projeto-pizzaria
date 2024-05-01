package com.projetopizzaria.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PedidoDto {

    private Long idPedido;

    private ClienteDto cliente;

    private FornadaDto fornada;

    private Instant dataHora;

}
