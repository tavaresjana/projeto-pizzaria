package com.projetopizzaria.repositories;

import com.projetopizzaria.models.PizzaPedida;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaPedidaRepository extends JpaRepository<PizzaPedida, Long> {
}
