package com.projetopizzaria.mappers;

import com.projetopizzaria.dto.PizzaPedidaDto;
import com.projetopizzaria.models.PizzaPedida;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PizzaPedidaImpl implements PizzaPedidaMapper{

    @Override
    public PizzaPedidaDto entidadeParaDto(PizzaPedida pizzaPedida) {
        PizzaPedidaDto pizzaPedidaDto = new PizzaPedidaDto();

        pizzaPedidaDto.setIdPizzaPedida(pizzaPedida.getIdPizzaPedida());
        pizzaPedidaDto.setPedido(pizzaPedida.getPedido());
        pizzaPedidaDto.setPizza(pizzaPedida.getPizza());
        pizzaPedidaDto.setQuantidade(pizzaPedida.getQuantidade());
        return pizzaPedidaDto;
    }

    @Override
    public PizzaPedida dtoParaEntidade(PizzaPedidaDto pizzaPedidaDto) {
       PizzaPedida pizzaPedida = new PizzaPedida();

       pizzaPedida.setIdPizzaPedida(pizzaPedida.getIdPizzaPedida());
       pizzaPedida.setPedido(pizzaPedida.getPedido());
       pizzaPedida.setPizza(pizzaPedida.getPizza());
       pizzaPedida.setQuantidade(pizzaPedida.getQuantidade());
       return pizzaPedida;
    }

    @Override
    public PizzaPedidaDto entidadeParaDtoOp(Optional<PizzaPedida> pizzaPedida) {
        PizzaPedidaDto pizzaPedidaDto = new PizzaPedidaDto();

        pizzaPedidaDto.setIdPizzaPedida(pizzaPedida.get().getIdPizzaPedida());
        pizzaPedidaDto.setPedido(pizzaPedida.get().getPedido());
        pizzaPedidaDto.setPizza(pizzaPedida.get().getPizza());
        pizzaPedidaDto.setQuantidade(pizzaPedida.get().getQuantidade());

        return pizzaPedidaDto;
    }


}
