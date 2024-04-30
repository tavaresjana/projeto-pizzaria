package com.projetopizzaria.service;

import com.projetopizzaria.dto.FornadaDto;
import com.projetopizzaria.mappers.FornadaMapper;
import com.projetopizzaria.models.Fornada;
import com.projetopizzaria.repositories.FornadaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FornadaService {

    @Autowired
    private FornadaRepository fornadaRepository;

    @Autowired
    private FornadaMapper fornadaMapper;

    public FornadaDto cadastrarFornada(FornadaDto fornadaDto){
        return fornadaMapper.entidadeParaDto(fornadaRepository.save(fornadaMapper.dtoParaEntidade(fornadaDto)));
    }

    public FornadaDto buscarFornadaPorId(Long id){
        return fornadaMapper.entidadeParaDtoOp(fornadaRepository.findById(id));
    }

    public FornadaDto buscarPorNumFornada(int numFornada) {
        Fornada fornada = fornadaRepository.buscarPorNumFornada(numFornada);
        FornadaDto fornadaDto = fornadaMapper.entidadeParaDto(fornada);
        return fornadaDto;
    }
}
