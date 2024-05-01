package com.projetopizzaria.mappers;

import com.projetopizzaria.dto.PizzaPedidaDto;
import com.projetopizzaria.models.PizzaPedida;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PizzaPedidaImpl implements PizzaPedidaMapper{

    @Autowired
    private PizzaMapper pizzaMapper;

    @Autowired
    private PedidoMapper pedidoMapper;

    @Override
    public PizzaPedidaDto entidadeParaDto(PizzaPedida pizzaPedida) {
        PizzaPedidaDto pizzaPedidaDto = new PizzaPedidaDto();

        pizzaPedidaDto.setIdPizzaPedida(pizzaPedida.getIdPizzaPedida());
        pizzaPedidaDto.setPedido(pedidoMapper.entidadeParaDto(pizzaPedida.getPedido()));
        pizzaPedidaDto.setPizza(pizzaMapper.entidadeParaDto(pizzaPedida.getPizza()));
        pizzaPedidaDto.setQuantidade(pizzaPedida.getQuantidade());
        return pizzaPedidaDto;
    }

    @Override
    public PizzaPedida dtoParaEntidade(PizzaPedidaDto pizzaPedidaDto) {
       PizzaPedida pizzaPedida = new PizzaPedida();

       pizzaPedida.setIdPizzaPedida(pizzaPedidaDto.getIdPizzaPedida());
       pizzaPedida.setPedido(pedidoMapper.dtoParaEntidade(pizzaPedidaDto.getPedido()));
       pizzaPedida.setPizza(pizzaMapper.dtoParaEntidade(pizzaPedidaDto.getPizza()));
       pizzaPedida.setQuantidade(pizzaPedidaDto.getQuantidade());
       return pizzaPedida;
    }

    @Override
    public PizzaPedidaDto entidadeParaDtoOp(Optional<PizzaPedida> pizzaPedida) {
        PizzaPedidaDto pizzaPedidaDto = new PizzaPedidaDto();

        pizzaPedidaDto.setIdPizzaPedida(pizzaPedida.get().getIdPizzaPedida());
        pizzaPedidaDto.setPedido(pedidoMapper.entidadeParaDtoOp(Optional.ofNullable(pizzaPedida.get().getPedido())));
        pizzaPedidaDto.setPizza(pizzaMapper.entidadeParaDtoOp(Optional.ofNullable(pizzaPedida.get().getPizza())));
        pizzaPedidaDto.setQuantidade(pizzaPedida.get().getQuantidade());

        return pizzaPedidaDto;
    }


}
