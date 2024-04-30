package com.projetopizzaria.service;

import com.projetopizzaria.dto.ClienteDto;
import com.projetopizzaria.dto.PizzaDto;
import com.projetopizzaria.mappers.PizzaMapper;
import com.projetopizzaria.models.Pizza;
import com.projetopizzaria.repositories.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PizzaService {

    @Autowired
    private PizzaRepository pizzaRepository;

    @Autowired
    private PizzaMapper pizzaMapper;

    public List<PizzaDto> buscarTodasPizzas() {
        List<Pizza> listaProduto = pizzaRepository.findAll();
        List<PizzaDto> listaProdutoDto = listaProduto.stream().map(pizzaMapper::entidadeParaDto).collect(Collectors.toList());
        return listaProdutoDto;
    }

    public PizzaDto cadastrarPizza(PizzaDto pizzaDto){
        return pizzaMapper.entidadeParaDto(pizzaRepository.save(pizzaMapper.dtoParaEntidade(pizzaDto)));
    }

    public PizzaDto buscarPizzaPorId(Long id){
        return pizzaMapper.entidadeParaDtoOp(pizzaRepository.findById(id));
    }
}
