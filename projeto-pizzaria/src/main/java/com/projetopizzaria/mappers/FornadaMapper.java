package com.projetopizzaria.mappers;

import com.projetopizzaria.dto.FornadaDto;
import com.projetopizzaria.models.Fornada;

import java.util.Optional;

public interface FornadaMapper {
    FornadaDto entidadeParaDto(Fornada fornada);

    Fornada dtoParaEntidade(FornadaDto fornadaDto);

    FornadaDto entidadeParaDtoOp(Optional<Fornada> fornada);
}
