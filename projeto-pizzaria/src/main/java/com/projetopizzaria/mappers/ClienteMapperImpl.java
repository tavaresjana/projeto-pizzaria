package com.projetopizzaria.mappers;

import com.projetopizzaria.dto.ClienteDto;
import com.projetopizzaria.models.Cliente;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ClienteMapperImpl implements ClienteMapper{

    @Override
    public ClienteDto entidadeParaDto(Cliente cliente) {
        ClienteDto clienteDto = new ClienteDto();
        clienteDto.setIdCliente(cliente.getIdCliente());
        clienteDto.setNome(cliente.getNome());
        clienteDto.setTelefone(cliente.getTelefone());
        clienteDto.setEndereco(cliente.getEndereco());
        clienteDto.setLogin(cliente.getLogin());
        clienteDto.setSenha(cliente.getSenha());
        return clienteDto;
    }

    @Override
    public Cliente dtoParaEntidade(ClienteDto clienteDto) {
        Cliente cliente = new Cliente();
        cliente.setIdCliente(clienteDto.getIdCliente());
        cliente.setNome(clienteDto.getNome());
        cliente.setTelefone(clienteDto.getTelefone());
        cliente.setEndereco(clienteDto.getEndereco());
        cliente.setLogin(clienteDto.getLogin());
        cliente.setSenha(clienteDto.getSenha());
        return cliente;
    }

    @Override
    public ClienteDto entidadeParaDtoOp(Optional<Cliente> cliente) {
        ClienteDto clienteDto = new ClienteDto();
        clienteDto.setIdCliente(cliente.get().getIdCliente());
        clienteDto.setNome(cliente.get().getNome());
        clienteDto.setTelefone(cliente.get().getTelefone());
        clienteDto.setEndereco(cliente.get().getEndereco());
        clienteDto.setLogin(cliente.get().getLogin());
        clienteDto.setSenha(cliente.get().getSenha());
        return clienteDto;
    }

}
