package com.proyectoingsoft.demo.repositories;

import com.proyectoingsoft.demo.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
