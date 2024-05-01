package com.projetopizzaria.service;

import com.projetopizzaria.dto.PedidoDto;
import com.projetopizzaria.dto.PizzaDto;
import com.projetopizzaria.dto.PizzaPedidaDto;
import com.projetopizzaria.mappers.PedidoMapper;
import com.projetopizzaria.mappers.PizzaMapper;
import com.projetopizzaria.mappers.PizzaPedidaMapper;
import com.projetopizzaria.models.Pedido;
import com.projetopizzaria.models.Pizza;
import com.projetopizzaria.models.PizzaPedida;
import com.projetopizzaria.repositories.PizzaPedidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PizzaPedidaService {

    @Autowired
    private PizzaPedidaRepository pizzaPedidaRepository;

    @Autowired
    private PizzaPedidaMapper pizzaPedidaMapper;

    @Autowired
    private PedidoMapper pedidoMapper;

    @Autowired
    private PizzaMapper pizzaMapper;

    @Autowired
    private PizzaService pizzaService;

    @Autowired
    private PedidoService pedidoService;


    public void cadastrarPizzaPedida(PizzaPedidaDto pizzaPedidaDto){
       //buscar pizzaDto e pedidoDto
        PizzaDto pizzaDto = pizzaService.buscarPizzaPorId(pizzaPedidaDto.getPizza().getIdPizza());
        PedidoDto pedidoDto = pedidoService.buscarPedidoPorId(pizzaPedidaDto.getPedido().getIdPedido());

        //transformar em model
        Pizza pizza = pizzaMapper.dtoParaEntidade(pizzaDto);
        Pedido pedido = pedidoMapper.dtoParaEntidade(pedidoDto);

        PizzaPedida pizzaPedida = pizzaPedidaMapper.dtoParaEntidade(pizzaPedidaDto);
        pizzaPedida.setPizza(pizza);
        pizzaPedida.setPedido(pedido);

        pizzaPedidaRepository.save(pizzaPedida);
    }



    public PizzaPedidaDto buscarPizzaPedidaPorId(Long id){
        return pizzaPedidaMapper.entidadeParaDtoOp(pizzaPedidaRepository.findById(id));
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
