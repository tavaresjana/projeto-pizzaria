package com.projetopizzaria.service;

import com.projetopizzaria.dto.ClienteDto;
import com.projetopizzaria.dto.FornadaDto;
import com.projetopizzaria.mappers.FornadaMapper;
import com.projetopizzaria.models.Cliente;
import com.projetopizzaria.models.Fornada;
import com.projetopizzaria.repositories.FornadaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    public FornadaDto atualizarFornada(Long id, FornadaDto fornadaDto){
        Optional<Fornada> optionalFornada = fornadaRepository.findById(id);

        Fornada fornadaEditada = optionalFornada.get();

        fornadaEditada.setNumFornada(fornadaDto.getNumFornada());
        fornadaEditada.setQtdPizzas(fornadaDto.getQtdPizzas());

        fornadaRepository.save(fornadaEditada);

        return fornadaMapper.entidadeParaDto(fornadaEditada);
    }
}
