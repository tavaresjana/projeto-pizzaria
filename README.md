# Projeto de Gestão de Pedidos de Pizzaria

Este projeto é uma aplicação de gestão de pedidos para uma pizzaria. Ele permite aos usuários realizar pedidos de pizzas, bebidas e acompanhar o status desses pedidos.

## Entidades Principais

### BebidaDto

- **idBebida**: Identificador único da bebida.
- **nome**: Nome da bebida.
- **preco**: Preço da bebida.

### ClienteDto

- **idCliente**: Identificador único do cliente.
- **nome**: Nome do cliente.
- **telefone**: Número de telefone do cliente.
- **endereco**: Endereço do cliente.
- **login**: Nome de usuário para login.
- **senha**: Senha para login.

### FornadaDto

- **idFornada**: Identificador único da fornada.
- **numFornada**: Número da fornada.
- **qtdPizzas**: Quantidade de pizzas na fornada.

### PedidoDto

- **idPedido**: Identificador único do pedido.
- **cliente**: Cliente que fez o pedido (referência para `ClienteDto`).
- **fornada**: Fornada à qual o pedido está associado (referência para `FornadaDto`).
- **dataHora**: Data e hora do pedido.

### PizzaDto

- **idPizza**: Identificador único da pizza.
- **nome**: Nome da pizza.
- **precoBase**: Preço base da pizza.
- **personalizada**: Indica se a pizza é personalizada.

### PizzaPedidaDto

- **idPizzaPedida**: Identificador único da pizza pedida.
- **pedido**: Pedido ao qual a pizza está associada (referência para `PedidoDto`).
- **pizza**: Pizza pedida (referência para `PizzaDto`).
- **quantidade**: Quantidade de pizzas pedidas.

## Funcionalidades

- Cadastro, atualização e exclusão de bebidas, clientes, fornadas, pizzas e pedidos.
- Realização de pedidos com detalhes sobre as pizzas e bebidas selecionadas.
- Acompanhamento do status dos pedidos em tempo real.
- Geração de relatórios sobre vendas, clientes frequentes, etc.

## Como Executar

1. Clone o repositório para sua máquina local:
git clone https://github.com/seu_usuario/seu_projeto.git

2. Abra o projeto em sua IDE preferida.

3. Configure o banco de dados MySQL conforme as configurações fornecidas no arquivo `application.properties`.

4. Compile e execute a aplicação.

5. Após iniciar a aplicação, acesse o Swagger pelo seguinte link:
http://localhost:8080/swagger-ui.html

## Tecnologias Utilizadas

- Java
- Spring Boot
- Hibernate
- MySQL


