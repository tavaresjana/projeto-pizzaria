package com.projetopizzaria.models;

import jakarta.persistence.Column;
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
@Table(name="pizza")
public class Pizza {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idPizza;
    private String nome;
    private BigDecimal precoBase;
    private boolean personalizada;
}
