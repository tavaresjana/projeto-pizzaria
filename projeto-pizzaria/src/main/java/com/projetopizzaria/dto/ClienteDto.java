package com.projetopizzaria.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDto {
    private Long idCliente;
    private String nome;
    private String telefone;
    private String endereco;
    private String login;
    private String senha;
}
