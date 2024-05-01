package com.projetopizzaria.mappers;

import com.projetopizzaria.dto.PizzaPedidaDto;
import com.projetopizzaria.models.PizzaPedida;

import java.util.Optional;

public interface PizzaPedidaMapper {
    PizzaPedidaDto entidadeParaDto(PizzaPedida pizzaPedida);

    PizzaPedida dtoParaEntidade(PizzaPedidaDto pizzaPedidaDto);

    PizzaPedidaDto entidadeParaDtoOp(Optional<PizzaPedida> pizzaPedida);

}
