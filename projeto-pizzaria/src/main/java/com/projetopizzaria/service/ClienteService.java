package com.projetopizzaria.service;

import com.projetopizzaria.dto.ClienteDto;
import com.projetopizzaria.mappers.ClienteMapper;
import com.projetopizzaria.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ClienteMapper clienteMapper;

    public ClienteDto cadastrarCliente(ClienteDto clienteDto){
        return clienteMapper.entidadeParaDto(clienteRepository.save(clienteMapper.dtoParaEntidade(clienteDto)));
    }
}
