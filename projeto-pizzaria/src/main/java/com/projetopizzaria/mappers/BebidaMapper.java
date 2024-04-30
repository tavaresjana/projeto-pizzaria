package com.projetopizzaria.mappers;

import com.projetopizzaria.dto.BebidaDto;
import com.projetopizzaria.models.Bebida;

import java.util.Optional;

public interface BebidaMapper {

    BebidaDto entidadeParaDto(Bebida bebida);

    Bebida dtoParaEntidade(BebidaDto bebidaDto);

    BebidaDto entidadeParaDtoOp(Optional<Bebida> bebida);
}
