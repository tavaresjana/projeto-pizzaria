package com.projetopizzaria.mappers;

import com.projetopizzaria.dto.PizzaDto;
import com.projetopizzaria.models.Pizza;

import java.util.Optional;

public interface PizzaMapper {

    PizzaDto entidadeParaDto(Pizza pizza);

    Pizza dtoParaEntidade(PizzaDto pizzaDto);

    PizzaDto entidadeParaDtoOp(Optional<Pizza> pizza);

}
