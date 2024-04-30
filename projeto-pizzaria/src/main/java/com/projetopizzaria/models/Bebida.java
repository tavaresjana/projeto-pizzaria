package com.projetopizzaria.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="bebida")
public class Bebida {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idBebida;
    private String nome;
    private BigDecimal preco;
}
