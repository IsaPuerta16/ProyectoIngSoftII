package com.proyectoingsoft.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String codigo;
    private String descripcion;
    private Double precioVenta;
    private Long impuestoId;
    private String medida;
    private Long categoriaId;

    // Constructor sin argumentos
    public Producto() {}

    // Constructor con argumentos
    public Producto(String codigo, String descripcion, Double precioVenta, Long impuestoId, String medida, Long categoriaId) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precioVenta = precioVenta;
        this.impuestoId = impuestoId;
        this.medida = medida;
        this.categoriaId = categoriaId;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(Double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Long getImpuestoId() {
        return impuestoId;
    }

    public void setImpuestoId(Long impuestoId) {
        this.impuestoId = impuestoId;
    }

    public String getMedida() {
        return medida;
    }

    public void setMedida(String medida) {
        this.medida = medida;
    }

    public Long getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Long categoriaId) {
        this.categoriaId = categoriaId;
    }

    // Método toString para representación en texto
    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", codigo='" + codigo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", precioVenta=" + precioVenta +
                ", impuestoId=" + impuestoId +
                ", medida='" + medida + '\'' +
                ", categoriaId=" + categoriaId +
                '}';
    }
}
