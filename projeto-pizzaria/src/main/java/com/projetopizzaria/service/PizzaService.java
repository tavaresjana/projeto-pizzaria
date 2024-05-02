package com.projetopizzaria.service;

import com.projetopizzaria.dto.PizzaDto;
import com.projetopizzaria.handler.exceptions.CampoVazioException;
import com.projetopizzaria.handler.exceptions.NaoEncontradoException;
import com.projetopizzaria.mappers.PizzaMapper;
import com.projetopizzaria.models.Pizza;
import com.projetopizzaria.repositories.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
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
        verificarCampoVazio(pizzaDto);
        return pizzaMapper.entidadeParaDto(pizzaRepository.save(pizzaMapper.dtoParaEntidade(pizzaDto)));
    }

    public PizzaDto buscarPizzaPorId(Long id){
        verificarId(id);
        return pizzaMapper.entidadeParaDtoOp(pizzaRepository.findById(id));
    }

    public PizzaDto atualizarPizza(PizzaDto pizzaDto){
        verificarId(pizzaDto.getIdPizza());
        Optional<Pizza> optionalCliente = pizzaRepository.findById(pizzaDto.getIdPizza());

        Pizza pizzaEditada = optionalCliente.get();

        pizzaEditada.setIdPizza(pizzaDto.getIdPizza());
        pizzaEditada.setNome(pizzaDto.getNome());
        pizzaEditada.setPrecoBase(pizzaDto.getPrecoBase());
        pizzaEditada.setPersonalizada(pizzaDto.isPersonalizada());

        pizzaRepository.save(pizzaEditada);

        return pizzaMapper.entidadeParaDto(pizzaEditada);
    }

    public void deletarPizza(Long id){
        verificarId(id);
        pizzaRepository.deleteById(id);
    }

    public void verificarCampoVazio(PizzaDto pizzaDto) {
        if (pizzaDto.getNome() == null || pizzaDto.getNome().isEmpty()
                || pizzaDto.getPrecoBase() == null || pizzaDto.getPrecoBase().compareTo(BigDecimal.ZERO) <= 0) {
            throw new CampoVazioException();
        }
    }

    public void verificarId(Long id) {
        Optional<Pizza> pizzaOptional = pizzaRepository.findById(id);
        if (pizzaOptional.isEmpty()) {
            throw new NaoEncontradoException("Pizza não encontrada.");
        }
    }
}
