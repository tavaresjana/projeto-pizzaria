package com.projetopizzaria.repositories;

import com.projetopizzaria.models.Fornada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FornadaRepository extends JpaRepository<Fornada, Long> {

    @Query(value = "select f from Fornada f where f.numFornada = ?1")
    Fornada buscarPorNumFornada(@Param("numFornada")int numFornada);
}
