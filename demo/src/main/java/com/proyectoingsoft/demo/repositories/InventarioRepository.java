package com.proyectoingsoft.demo.repositories;

import com.proyectoingsoft.demo.models.Inventario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventarioRepository extends JpaRepository<Inventario, Long> {
}
