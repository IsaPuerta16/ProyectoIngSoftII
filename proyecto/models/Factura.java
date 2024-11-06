package com.proyectoingsoft.demo.models;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate fecha;

    @Column(nullable = false)
    private Double total;

    // Constructor vacío
    public Factura() {}

    // Constructor con parámetros
    public Factura(LocalDate fecha, Double total) {
        this.fecha = fecha;
        this.total = total;
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
