package com.projetopizzaria.service;

import com.projetopizzaria.dto.FornadaDto;
import com.projetopizzaria.handler.exceptions.CampoVazioException;
import com.projetopizzaria.handler.exceptions.NaoEncontradoException;
import com.projetopizzaria.mappers.FornadaMapper;
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

    public FornadaDto cadastrarFornada(FornadaDto fornadaDto) {
        verificarCampoVazio(fornadaDto);
        return fornadaMapper.entidadeParaDto(fornadaRepository.save(fornadaMapper.dtoParaEntidade(fornadaDto)));
    }

    public FornadaDto buscarFornadaPorId(Long id) {
        verificarId(id);
        return fornadaMapper.entidadeParaDtoOp(fornadaRepository.findById(id));
    }

    public FornadaDto buscarPorNumFornada(int numFornada) {
        Fornada fornada = fornadaRepository.buscarPorNumFornada(numFornada);
        if(fornada==null){
            throw new NaoEncontradoException("Fornada não encontrada.");
        }
        FornadaDto fornadaDto = fornadaMapper.entidadeParaDto(fornada);
        return fornadaDto;
    }

    public FornadaDto atualizarFornada(Long id, FornadaDto fornadaDto) {
        verificarId(fornadaDto.getIdFornada());
        Optional<Fornada> optionalFornada = fornadaRepository.findById(id);

        Fornada fornadaEditada = optionalFornada.get();

        fornadaEditada.setNumFornada(fornadaDto.getNumFornada());
        fornadaEditada.setQtdPizzas(fornadaDto.getQtdPizzas());

        fornadaRepository.save(fornadaEditada);

        return fornadaMapper.entidadeParaDto(fornadaEditada);
    }

    public void deletarFornada(Long id) {
        verificarId(id);
        fornadaRepository.deleteById(id);
    }


    public void verificarCampoVazio(FornadaDto fornadaDto) {
        if (fornadaDto.getNumFornada() <= 0 || fornadaDto.getQtdPizzas() <= 0) {
            throw new CampoVazioException();
        }
    }

    public void verificarId(Long id) {
        Optional<Fornada> fornadaOptional = fornadaRepository.findById(id);
        if (fornadaOptional.isEmpty()) {
            throw new NaoEncontradoException("Fornada não encontrada.");
        }
    }
}
