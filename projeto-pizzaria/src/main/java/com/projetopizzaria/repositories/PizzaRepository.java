package com.projetopizzaria.repositories;

import com.projetopizzaria.models.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaRepository extends JpaRepository<Pizza, Long> {
}
