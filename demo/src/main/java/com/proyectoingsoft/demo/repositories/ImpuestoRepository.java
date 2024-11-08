package com.proyectoingsoft.demo.repositories;

import com.proyectoingsoft.demo.models.Impuesto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImpuestoRepository extends JpaRepository<Impuesto, Long> {
}
