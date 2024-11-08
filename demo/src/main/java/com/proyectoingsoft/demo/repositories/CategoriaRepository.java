package com.proyectoingsoft.demo.repositories;

import com.proyectoingsoft.demo.models.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
