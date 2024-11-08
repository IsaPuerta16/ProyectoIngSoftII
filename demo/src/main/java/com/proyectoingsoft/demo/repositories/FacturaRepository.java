package com.proyectoingsoft.demo.repositories;

import com.proyectoingsoft.demo.models.Factura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacturaRepository extends JpaRepository<Factura, Long> {
}
