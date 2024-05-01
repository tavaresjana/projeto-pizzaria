package com.projetopizzaria.mappers;

import com.projetopizzaria.dto.PedidoDto;
import com.projetopizzaria.models.Pedido;

import java.util.Optional;

public interface PedidoMapper {
    PedidoDto entidadeParaDto(Pedido pedido);

    Pedido dtoParaEntidade(PedidoDto pedidoDto);

    PedidoDto entidadeParaDtoOp(Optional<Pedido> pedido);
}
