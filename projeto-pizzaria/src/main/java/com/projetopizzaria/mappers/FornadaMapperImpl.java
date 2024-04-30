package com.projetopizzaria.mappers;

import com.projetopizzaria.dto.FornadaDto;
import com.projetopizzaria.dto.PizzaDto;
import com.projetopizzaria.models.Fornada;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FornadaMapperImpl implements FornadaMapper {
    @Override
    public FornadaDto entidadeParaDto(Fornada fornada) {
        FornadaDto fornadaDto = new FornadaDto();

        fornadaDto.setIdFornada(fornada.getIdFornada());
        fornadaDto.setNumFornada(fornada.getNumFornada());
        fornadaDto.setQtdPizzas(fornada.getQtdPizzas());
        return fornadaDto;
    }

    @Override
    public Fornada dtoParaEntidade(FornadaDto fornadaDto) {
        Fornada fornada = new Fornada();

        fornada.setIdFornada(fornadaDto.getIdFornada());
        fornada.setNumFornada(fornadaDto.getNumFornada());
        fornada.setQtdPizzas(fornadaDto.getQtdPizzas());
        return fornada;
    }

    @Override
    public FornadaDto entidadeParaDtoOp(Optional<Fornada> fornada) {
        FornadaDto fornadaDto = new FornadaDto();

        fornadaDto.setIdFornada(fornada.get().getIdFornada());
        fornadaDto.setNumFornada(fornada.get().getNumFornada());
        fornadaDto.setQtdPizzas(fornada.get().getQtdPizzas());
        return fornadaDto;
    }
}
