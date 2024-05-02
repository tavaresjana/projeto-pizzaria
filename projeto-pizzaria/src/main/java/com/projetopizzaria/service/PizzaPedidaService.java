package com.projetopizzaria.service;

import com.projetopizzaria.dto.PedidoDto;
import com.projetopizzaria.dto.PizzaDto;
import com.projetopizzaria.dto.PizzaPedidaDto;
import com.projetopizzaria.mappers.ClienteMapper;
import com.projetopizzaria.mappers.PedidoMapper;
import com.projetopizzaria.mappers.PizzaMapper;
import com.projetopizzaria.mappers.PizzaPedidaMapper;
import com.projetopizzaria.models.Pedido;
import com.projetopizzaria.models.Pizza;
import com.projetopizzaria.models.PizzaPedida;
import com.projetopizzaria.repositories.ClienteRepository;
import com.projetopizzaria.repositories.PizzaPedidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

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

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ClienteMapper clienteMapper;

    public void cadastrarPizzaPedida(PizzaPedidaDto pizzaPedidaDto) throws Exception {

        //buscar pizzaDto e pedidoDto
        PizzaDto pizzaDto = pizzaService.buscarPizzaPorId(pizzaPedidaDto.getPizza().getIdPizza());
        PedidoDto pedidoDto = pedidoService.buscarPedidoPorId(pizzaPedidaDto.getPedido().getIdPedido());

        /*if(ObjectUtils.isEmpty(pizzaDto.getIdPizza()) || ObjectUtils.isEmpty(pedidoDto.getIdPedido())){
            throw new Exception("Id não informado.");
        }
        Optional<Cliente> cliente = clienteRepository.findById(pizzaPedidaDto.getPedido().getCliente().getIdCliente());
        pizzaPedidaDto.getPedido().setCliente(clienteMapper.entidadeParaDtoOp(cliente)); */

        pizzaPedidaDto.setPizza(pizzaDto);
        pizzaPedidaDto.setPedido(pedidoDto);
        //transformar em model
        PizzaPedida pizzaPedida = pizzaPedidaMapper.dtoParaEntidade(pizzaPedidaDto);

        pizzaPedidaRepository.save(pizzaPedida);
    }



    public PizzaPedidaDto buscarPizzaPedidaPorId(Long id){
        return pizzaPedidaMapper.entidadeParaDtoOp(pizzaPedidaRepository.findById(id));
    }

    public String cacularValorTotal(Long id){
        Optional<PizzaPedida> optionalPizzaPedida = pizzaPedidaRepository.findById(id);
        PizzaPedida pizzaPedida = optionalPizzaPedida.get();

        BigDecimal valorPizza = pizzaPedida.getPizza().getPrecoBase();
        BigDecimal qtd = new BigDecimal(pizzaPedida.getQuantidade());

        BigDecimal valorTotalPizzaPedida = (valorPizza.multiply(qtd));
        return "Valor total do Pedido nº "+pizzaPedida.getPedido().getIdPedido()+" é "+valorTotalPizzaPedida;
    }

    public PizzaPedidaDto atualizarPizzaPedida(PizzaPedidaDto pizzaPedidaDto){
        Optional<PizzaPedida> optionalPizzaPedida = pizzaPedidaRepository.findById(pizzaPedidaDto.getIdPizzaPedida());
        PizzaPedida pizzaPedidaEditada = optionalPizzaPedida.get();

        //buscar pizzaDto e pedidoDto
        PizzaDto pizzaDto = pizzaService.buscarPizzaPorId(pizzaPedidaDto.getPizza().getIdPizza());
        PedidoDto pedidoDto = pedidoService.buscarPedidoPorId(pizzaPedidaDto.getPedido().getIdPedido());

        Pizza pizza = pizzaMapper.dtoParaEntidade(pizzaDto);
        Pedido pedido = pedidoMapper.dtoParaEntidade(pedidoDto);

        pizzaPedidaEditada.setIdPizzaPedida(pizzaPedidaDto.getIdPizzaPedida());
        pizzaPedidaEditada.setPedido(pedido);
        pizzaPedidaEditada.setPizza(pizza);
        pizzaPedidaEditada.setQuantidade(pizzaPedidaDto.getQuantidade());

        pizzaPedidaRepository.save(pizzaPedidaEditada);
        return pizzaPedidaMapper.entidadeParaDto(pizzaPedidaEditada);
    }
}
