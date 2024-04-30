package com.projetopizzaria.service;

import com.projetopizzaria.dto.BebidaDto;
import com.projetopizzaria.mappers.BebidaMapper;
import com.projetopizzaria.repositories.BebidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BebidaService {

    @Autowired
    private BebidaRepository bebidaRepository;

    @Autowired
    private BebidaMapper bebidaMapper;


    public BebidaDto cadastrarBebida(BebidaDto bebidaDto){
        return bebidaMapper.entidadeParaDto(bebidaRepository.save(bebidaMapper.dtoParaEntidade(bebidaDto)));
    }

    public BebidaDto buscarBebidaPorId(Long id){
        return bebidaMapper.entidadeParaDtoOp(bebidaRepository.findById(id));
    }
}
