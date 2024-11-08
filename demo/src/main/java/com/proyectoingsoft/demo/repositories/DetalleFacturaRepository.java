package com.proyectoingsoft.demo.repositories;

import com.proyectoingsoft.demo.models.DetalleFactura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetalleFacturaRepository extends JpaRepository<DetalleFactura, Long> {
}
