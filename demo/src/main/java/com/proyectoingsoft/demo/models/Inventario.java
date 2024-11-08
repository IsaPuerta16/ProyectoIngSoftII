package com.proyectoingsoft.demo.models;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Inventario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date fecha;
    private String tipoMovimiento;
    private Integer entrada;
    private Integer salida;
    private String observaciones;
    private Long idProducto;

    // Constructor sin argumentos
    public Inventario() {}

    // Constructor con argumentos
    public Inventario(Date fecha, String tipoMovimiento, Integer entrada, Integer salida, String observaciones, Long idProducto) {
        this.fecha = fecha;
        this.tipoMovimiento = tipoMovimiento;
        this.entrada = entrada;
        this.salida = salida;
        this.observaciones = observaciones;
        this.idProducto = idProducto;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(String tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public Integer getEntrada() {
        return entrada;
    }

    public void setEntrada(Integer entrada) {
        this.entrada = entrada;
    }

    public Integer getSalida() {
        return salida;
    }

    public void setSalida(Integer salida) {
        this.salida = salida;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }

    // Método toString para representación en texto
    @Override
    public String toString() {
        return "Inventario{" +
                "id=" + id +
                ", fecha=" + fecha +
                ", tipoMovimiento='" + tipoMovimiento + '\'' +
                ", entrada=" + entrada +
                ", salida=" + salida +
                ", observaciones='" + observaciones + '\'' +
                ", idProducto=" + idProducto +
                '}';
    }
}
