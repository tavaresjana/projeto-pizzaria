package com.projetopizzaria.mappers;

import com.projetopizzaria.dto.PedidoDto;
import com.projetopizzaria.models.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PedidoMapperImpl implements PedidoMapper{

    @Autowired
    private ClienteMapper clienteMapper;

    @Override
    public PedidoDto entidadeParaDto(Pedido pedido) {
        PedidoDto pedidoDto = new PedidoDto();
        pedidoDto.setIdPedido(pedido.getIdPedido());
        pedidoDto.setCliente(clienteMapper.entidadeParaDto(pedido.getCliente()));
        pedidoDto.setDataHora(pedido.getDataHora());
        return pedidoDto;
    }

    @Override
    public Pedido dtoParaEntidade(PedidoDto pedidoDto) {
        Pedido pedido = new Pedido();
        pedido.setIdPedido(pedidoDto.getIdPedido());
        pedido.setCliente(clienteMapper.dtoParaEntidade(pedidoDto.getCliente()));
        pedido.setDataHora(pedidoDto.getDataHora());
        return pedido;
    }

    @Override
    public PedidoDto entidadeParaDtoOp(Optional<Pedido> pedido) {
        PedidoDto pedidoDto = new PedidoDto();
        pedidoDto.setIdPedido(pedido.get().getIdPedido());
        pedidoDto.setCliente(clienteMapper.entidadeParaDtoOp(Optional.ofNullable(pedido.get().getCliente())));
        pedidoDto.setDataHora(pedido.get().getDataHora());
        return pedidoDto;
    }
}
