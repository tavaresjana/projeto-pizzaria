package com.projetopizzaria.service;

import com.projetopizzaria.dto.ClienteDto;
import com.projetopizzaria.dto.PizzaDto;
import com.projetopizzaria.dto.PizzaPedidaDto;
import com.projetopizzaria.mappers.PizzaPedidaMapper;
import com.projetopizzaria.models.Cliente;
import com.projetopizzaria.models.Pedido;
import com.projetopizzaria.models.Pizza;
import com.projetopizzaria.models.PizzaPedida;
import com.projetopizzaria.repositories.PizzaPedidaRepository;
import com.projetopizzaria.repositories.PizzaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PizzaPedidaService {

    @Autowired
    private PizzaPedidaRepository pizzaPedidaRepository;

    @Autowired
    private PizzaPedidaMapper pizzaPedidaMapper;

    /*@Autowired
    private PedidoRepository pedidoRepository;*/

    @Autowired
    private PizzaRepository pizzaRepository;

    public PizzaPedidaDto cadastrarPizzaPedida(PizzaPedidaDto pizzaPedidaDto){
        PizzaPedida pizzaPedida = new PizzaPedida();
        Pedido pedido = new Pedido();
        Pizza pizza = new Pizza();

        /*Pedido pedido = pedidoRepository.findById(pizzaPedidaDto.getPedidoId())
                .orElseThrow(() -> new EntityNotFoundException("Pedido não encontrado"));*/

        pizza = pizzaRepository.findById(pizzaPedidaDto.getPizza().getIdPizza())
                .orElseThrow(() -> new EntityNotFoundException("Pizza não encontrada"));

        pizzaPedida.setPedido(pizzaPedidaDto.getPedido());
        pizzaPedida.setPizza(pizza);
        pizzaPedida.setQuantidade(pizzaPedidaDto.getQuantidade());

        return pizzaPedidaMapper.entidadeParaDto(pizzaPedidaRepository.save(pizzaPedida));

     //   return pizzaPedidaMapper.entidadeParaDto(pizzaPedidaRepository.save(pizzaPedidaMapper.dtoParaEntidade(pizzaPedidaDto)));
       // PizzaPedida pizzaPedida = pizzaPedidaMapper.dtoParaEntidade(pizzaPedidaDto);
      //  PizzaPedida savedPizzaPedida = pizzaPedidaRepository.save(pizzaPedida);
        //return pizzaPedidaMapper.entidadeParaDto(savedPizzaPedida);
    }

    public PizzaPedidaDto buscarPizzaPedidaPorId(Long id){
        return pizzaPedidaMapper.entidadeParaDtoOp(pizzaPedidaRepository.findById(id));
    }

    public PizzaPedidaDto atualizarPizzaPedida(PizzaPedidaDto pizzaPedidaDto){
        Optional<PizzaPedida> optionalPizzaPedida = pizzaPedidaRepository.findById(pizzaPedidaDto.getIdPizzaPedida());

        PizzaPedida pizzaPedidaEditada = optionalPizzaPedida.get();

        pizzaPedidaEditada.setIdPizzaPedida(pizzaPedidaDto.getIdPizzaPedida());
        pizzaPedidaEditada.setPedido(pizzaPedidaDto.getPedido());
        pizzaPedidaEditada.setPizza(pizzaPedidaDto.getPizza());
        pizzaPedidaEditada.setQuantidade(pizzaPedidaDto.getQuantidade());

        pizzaPedidaRepository.save(pizzaPedidaEditada);
        return pizzaPedidaMapper.entidadeParaDto(pizzaPedidaEditada);
    }
}
