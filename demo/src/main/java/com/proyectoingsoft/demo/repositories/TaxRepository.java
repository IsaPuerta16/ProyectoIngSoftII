package com.proyectoingsoft.demo.repositories;

import com.proyectoingsoft.demo.models.Tax;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaxRepository extends JpaRepository<Tax, Long> {
}
