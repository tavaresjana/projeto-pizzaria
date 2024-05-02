package com.projetopizzaria.service;

import com.projetopizzaria.dto.BebidaDto;
import com.projetopizzaria.handler.exceptions.CampoVazioException;
import com.projetopizzaria.handler.exceptions.NaoEncontradoException;
import com.projetopizzaria.mappers.BebidaMapper;
import com.projetopizzaria.models.Bebida;
import com.projetopizzaria.repositories.BebidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class BebidaService {

    @Autowired
    private BebidaRepository bebidaRepository;

    @Autowired
    private BebidaMapper bebidaMapper;


    public BebidaDto cadastrarBebida(BebidaDto bebidaDto){
        verificarCampoVazio(bebidaDto);
        return bebidaMapper.entidadeParaDto(bebidaRepository.save(bebidaMapper.dtoParaEntidade(bebidaDto)));
    }

    public BebidaDto buscarBebidaPorId(Long id){
        verificarIdBebida(id);
        return bebidaMapper.entidadeParaDtoOp(bebidaRepository.findById(id));
    }

    public BebidaDto atualizarBebida(BebidaDto bebidaDto){
        verificarIdBebida(bebidaDto.getIdBebida());
        Optional<Bebida> optionalBebida = bebidaRepository.findById(bebidaDto.getIdBebida());

        Bebida bebidaEditada = optionalBebida.get();

        bebidaEditada.setIdBebida(bebidaDto.getIdBebida());
        bebidaEditada.setNome(bebidaDto.getNome());
        bebidaEditada.setPreco(bebidaDto.getPreco());

        bebidaRepository.save(bebidaEditada);

        return bebidaMapper.entidadeParaDto(bebidaEditada);
    }

    public void deletarBebida(Long id){
        verificarIdBebida(id);
        bebidaRepository.deleteById(id);
    }

    public void verificarCampoVazio(BebidaDto bebidaDto) {
        if (bebidaDto.getNome() == null || bebidaDto.getNome().isEmpty()
                || bebidaDto.getPreco() == null || bebidaDto.getPreco().compareTo(BigDecimal.ZERO) <= 0) {
            throw new CampoVazioException();
        }
    }

    public void verificarIdBebida(Long idBebida) {
        Optional<Bebida> bebidaOptional = bebidaRepository.findById(idBebida);
        if (bebidaOptional.isEmpty()) {
            throw new NaoEncontradoException("Bebida não encontrada.");
        }
    }

}
