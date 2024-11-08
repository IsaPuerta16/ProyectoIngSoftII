package com.proyectoingsoft.demo.repositories;

import com.proyectoingsoft.demo.models.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
