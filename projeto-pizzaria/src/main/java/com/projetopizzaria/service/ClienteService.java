package com.projetopizzaria.service;

import com.projetopizzaria.dto.ClienteDto;
import com.projetopizzaria.mappers.ClienteMapper;
import com.projetopizzaria.models.Cliente;
import com.projetopizzaria.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ClienteMapper clienteMapper;

    public ClienteDto cadastrarCliente(ClienteDto clienteDto){
        return clienteMapper.entidadeParaDto(clienteRepository.save(clienteMapper.dtoParaEntidade(clienteDto)));
    }

    public ClienteDto buscarClientePorId(Long id){
        return clienteMapper.entidadeParaDtoOp(clienteRepository.findById(id));
    }

    public ClienteDto atualizarCliente(ClienteDto clienteDto){
        Optional<Cliente> optionalCliente = clienteRepository.findById(clienteDto.getIdCliente());

        Cliente clienteEditado = optionalCliente.get();

        clienteEditado.setNome(clienteDto.getNome());
        clienteEditado.setTelefone(clienteDto.getTelefone());
        clienteEditado.setEndereco(clienteDto.getEndereco());
        clienteEditado.setLogin(clienteDto.getLogin());
        clienteEditado.setSenha(clienteDto.getSenha());

        clienteRepository.save(clienteEditado);

        return clienteMapper.entidadeParaDto(clienteEditado);
    }

    public void deletarCliente(Long id){
        clienteRepository.deleteById(id);
    }
}
