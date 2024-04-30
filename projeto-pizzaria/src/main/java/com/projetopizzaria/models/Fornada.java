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

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="fornada")
public class Fornada {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idFornada;
    @Column(unique = true)
    private int numFornada;
    private int qtdPizzas;
}
