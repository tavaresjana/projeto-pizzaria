package com.projetopizzaria.service;

import com.projetopizzaria.dto.BebidaDto;
import com.projetopizzaria.dto.ClienteDto;
import com.projetopizzaria.mappers.BebidaMapper;
import com.projetopizzaria.repositories.BebidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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
