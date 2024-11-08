package com.proyectoingsoft.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class MetodoPago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descripcion;
    private String identificador;

    // Constructor sin argumentos
    public MetodoPago() {}

    // Constructor con argumentos
    public MetodoPago(String descripcion, String identificador) {
        this.descripcion = descripcion;
        this.identificador = identificador;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    // Método toString para representación en texto
    @Override
    public String toString() {
        return "MetodoPago{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                ", identificador='" + identificador + '\'' +
                '}';
    }
}
