package com.projetopizzaria.mappers;

import com.projetopizzaria.dto.PizzaDto;
import com.projetopizzaria.models.Pizza;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PizzaMapperImpl implements PizzaMapper {

    @Override
    public PizzaDto entidadeParaDto(Pizza pizza) {
        PizzaDto pizzaDto = new PizzaDto();

        pizzaDto.setIdPizza(pizza.getIdPizza());
        pizzaDto.setNome(pizza.getNome());
        pizzaDto.setPrecoBase(pizza.getPrecoBase());
        pizzaDto.setPersonalizada(pizza.isPersonalizada());
        return pizzaDto;
    }

    @Override
    public Pizza dtoParaEntidade(PizzaDto pizzaDto) {
        Pizza pizza = new Pizza();

        pizza.setIdPizza(pizzaDto.getIdPizza());
        pizza.setNome(pizzaDto.getNome());
        pizza.setPrecoBase(pizzaDto.getPrecoBase());
        pizza.setPersonalizada(pizzaDto.isPersonalizada());
        return pizza;
    }

    @Override
    public PizzaDto entidadeParaDtoOp(Optional<Pizza> pizza) {
        PizzaDto pizzaDto = new PizzaDto();

        pizzaDto.setIdPizza(pizza.get().getIdPizza());
        pizzaDto.setNome(pizza.get().getNome());
        pizzaDto.setPrecoBase(pizza.get().getPrecoBase());
        pizzaDto.setPersonalizada(pizza.get().isPersonalizada());
        return pizzaDto;
    }
}
