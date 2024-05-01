package com.projetopizzaria.service;

import com.projetopizzaria.dto.ClienteDto;
import com.projetopizzaria.dto.FornadaDto;
import com.projetopizzaria.dto.PedidoDto;
import com.projetopizzaria.mappers.ClienteMapper;
import com.projetopizzaria.mappers.FornadaMapper;
import com.projetopizzaria.mappers.PedidoMapper;
import com.projetopizzaria.models.Cliente;
import com.projetopizzaria.models.Fornada;
import com.projetopizzaria.models.Pedido;
import com.projetopizzaria.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private FornadaService fornadaService;

    @Autowired
    private PedidoMapper pedidoMapper;

    @Autowired
    private ClienteMapper clienteMapper;

    @Autowired
    private FornadaMapper fornadaMapper;

    public PedidoDto cadastrarPedido(PedidoDto pedidoDto){
        //faço uma busca por cliente&fornada, usando o id informado no json
        ClienteDto clienteDto = clienteService.buscarClientePorId(pedidoDto.getCliente().getIdCliente());
        FornadaDto fornadaDto = fornadaService.buscarFornadaPorId((pedidoDto.getFornada().getIdFornada()));

        //tranformo em model
        Cliente cliente = clienteMapper.dtoParaEntidade(clienteDto);
        Fornada fornada = fornadaMapper.dtoParaEntidade(fornadaDto);

        //tranformo o pedidoDto em model e seto clienteModel e FornadaModel em PedidoModel.
        Pedido pedido = pedidoMapper.dtoParaEntidade(pedidoDto);
        pedido.setCliente(cliente);
        pedido.setFornada(fornada);

        //salvo pedido
        pedidoRepository.save(pedido);

        return pedidoMapper.entidadeParaDto(pedidoRepository.save(pedido));
    }

    public PedidoDto buscarPedidoPorId(Long id){
        return pedidoMapper.entidadeParaDtoOp(pedidoRepository.findById(id));
    }

    /*public PizzaPedidaDto atualizarPizzaPedida(PizzaPedidaDto pizzaPedidaDto){
        Optional<PizzaPedida> optionalPizzaPedida = pizzaPedidaRepository.findById(pizzaPedidaDto.getIdPizzaPedida());

        PizzaPedida pizzaPedidaEditada = optionalPizzaPedida.get();

        pizzaPedidaEditada.setIdPizzaPedida(pizzaPedidaDto.getIdPizzaPedida());
        pizzaPedidaEditada.setPedido(pizzaPedidaDto.getPedido());
        pizzaPedidaEditada.setPizza(pizzaPedidaDto.getPizza());
        pizzaPedidaEditada.setQuantidade(pizzaPedidaDto.getQuantidade());

        pizzaPedidaRepository.save(pizzaPedidaEditada);
        return pizzaPedidaMapper.entidadeParaDto(pizzaPedidaEditada);
    }*/

}
