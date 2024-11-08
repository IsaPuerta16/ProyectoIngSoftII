package com.proyectoingsoft.demo.models;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String codigo;
    private Date fecha;
    private Double subtotal;
    private Double totalImpuestos;
    private Double total;
    private String estado;
    private Long idCliente;
    private Long idMetodoPago;

    // Constructor sin argumentos
    public Factura() {}

    // Constructor con argumentos
    public Factura(String codigo, Date fecha, Double subtotal, Double totalImpuestos, Double total, String estado, Long idCliente, Long idMetodoPago) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.subtotal = subtotal;
        this.totalImpuestos = totalImpuestos;
        this.total = total;
        this.estado = estado;
        this.idCliente = idCliente;
        this.idMetodoPago = idMetodoPago;
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public Double getTotalImpuestos() {
        return totalImpuestos;
    }

    public void setTotalImpuestos(Double totalImpuestos) {
        this.totalImpuestos = totalImpuestos;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public Long getIdMetodoPago() {
        return idMetodoPago;
    }

    public void setIdMetodoPago(Long idMetodoPago) {
        this.idMetodoPago = idMetodoPago;
    }

    // Método toString para representación en texto
    @Override
    public String toString() {
        return "Factura{" +
                "id=" + id +
                ", codigo='" + codigo + '\'' +
                ", fecha=" + fecha +
                ", subtotal=" + subtotal +
                ", totalImpuestos=" + totalImpuestos +
                ", total=" + total +
                ", estado='" + estado + '\'' +
                ", idCliente=" + idCliente +
                ", idMetodoPago=" + idMetodoPago +
                '}';
    }
}
