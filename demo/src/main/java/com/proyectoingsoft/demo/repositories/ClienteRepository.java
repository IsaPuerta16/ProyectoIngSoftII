package com.proyectoingsoft.demo.repositories;

import com.proyectoingsoft.demo.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
