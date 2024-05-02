package com.projetopizzaria.service;

import com.projetopizzaria.dto.ClienteDto;
import com.projetopizzaria.handler.exceptions.CampoVazioException;
import com.projetopizzaria.handler.exceptions.NaoEncontradoException;
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
        verificarCampoVazio(clienteDto);
        return clienteMapper.entidadeParaDto(clienteRepository.save(clienteMapper.dtoParaEntidade(clienteDto)));
    }

    public ClienteDto buscarClientePorId(Long id){
        verificarId(id);
        return clienteMapper.entidadeParaDtoOp(clienteRepository.findById(id));
    }

    public ClienteDto atualizarCliente(ClienteDto clienteDto){
        verificarId(clienteDto.getIdCliente());
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
        verificarId(id);
        clienteRepository.deleteById(id);
    }

    public void verificarCampoVazio(ClienteDto clienteDto) {
        if (clienteDto.getNome() == null || clienteDto.getNome().isEmpty()
                || clienteDto.getTelefone() == null || clienteDto.getTelefone().isEmpty()
                || clienteDto.getEndereco() == null || clienteDto.getEndereco().isEmpty()
                || clienteDto.getLogin() == null || clienteDto.getLogin().isEmpty()
                || clienteDto.getSenha() == null || clienteDto.getSenha().isEmpty()) {
            throw new CampoVazioException();
        }
    }

    public void verificarId(Long id) {
        Optional<Cliente> clienteOptional = clienteRepository.findById(id);
        if (clienteOptional.isEmpty()) {
            throw new NaoEncontradoException("Cliente não encontrado.");
        }
    }

}
