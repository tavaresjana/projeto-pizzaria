package com.projetopizzaria.mappers;

import com.projetopizzaria.dto.BebidaDto;
import com.projetopizzaria.models.Bebida;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class BebidaMapperImpl implements BebidaMapper {

    @Override
    public BebidaDto entidadeParaDto(Bebida bebida) {
        BebidaDto bebidaDto = new BebidaDto();
        bebidaDto.setIdBebida(bebida.getIdBebida());
        bebidaDto.setNome(bebida.getNome());
        bebidaDto.setPreco(bebida.getPreco());

        return bebidaDto;
    }

    @Override
    public Bebida dtoParaEntidade(BebidaDto bebidaDto) {
        Bebida bebida = new Bebida();
        bebida.setIdBebida(bebidaDto.getIdBebida());
        bebida.setNome(bebidaDto.getNome());
        bebida.setPreco(bebidaDto.getPreco());

        return bebida;
    }

    @Override
    public BebidaDto entidadeParaDtoOp(Optional<Bebida> bebida) {
        BebidaDto bebidaDto = new BebidaDto();

        bebidaDto.setIdBebida(bebida.get().getIdBebida());
        bebidaDto.setNome(bebida.get().getNome());
        bebidaDto.setPreco(bebida.get().getPreco());
        return bebidaDto;
    }
}
