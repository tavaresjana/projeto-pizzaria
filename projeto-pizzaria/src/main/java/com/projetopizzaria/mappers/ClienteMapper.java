package com.projetopizzaria.mappers;

import com.projetopizzaria.dto.ClienteDto;
import com.projetopizzaria.models.Cliente;

import java.util.Optional;

public interface ClienteMapper {

    ClienteDto entidadeParaDto(Cliente cliente);

    Cliente dtoParaEntidade(ClienteDto clienteDto);

    ClienteDto entidadeParaDtoOp(Optional<Cliente> cliente);
}
