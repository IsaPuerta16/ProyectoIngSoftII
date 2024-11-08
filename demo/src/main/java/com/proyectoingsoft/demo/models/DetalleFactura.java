package com.proyectoingsoft.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class DetalleFactura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer cantidad;
    private Double valorTotal;
    private Double descuento;
    private Long idProducto;
    private Long idFactura;

    // Constructor sin argumentos
    public DetalleFactura() {}

    // Constructor con argumentos
    public DetalleFactura(Integer cantidad, Double valorTotal, Double descuento, Long idProducto, Long idFactura) {
        this.cantidad = cantidad;
        this.valorTotal = valorTotal;
        this.descuento = descuento;
        this.idProducto = idProducto;
        this.idFactura = idFactura;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Double getDescuento() {
        return descuento;
    }

    public void setDescuento(Double descuento) {
        this.descuento = descuento;
    }

    public Long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }

    public Long getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(Long idFactura) {
        this.idFactura = idFactura;
    }

    // Método toString para representación en texto
    @Override
    public String toString() {
        return "DetalleFactura{" +
                "id=" + id +
                ", cantidad=" + cantidad +
                ", valorTotal=" + valorTotal +
                ", descuento=" + descuento +
                ", idProducto=" + idProducto +
                ", idFactura=" + idFactura +
                '}';
    }
}
