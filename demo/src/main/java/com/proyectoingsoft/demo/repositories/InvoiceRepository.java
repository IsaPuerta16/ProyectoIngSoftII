package com.proyectoingsoft.demo.repositories;

import com.proyectoingsoft.demo.models.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
}
