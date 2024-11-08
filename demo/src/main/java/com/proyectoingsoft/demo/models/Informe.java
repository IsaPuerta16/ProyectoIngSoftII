package com.proyectoingsoft.demo.models;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Informe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tipoInforme;
    private Date fecha;
    private String datosJson;

    // Constructor sin argumentos
    public Informe() {}

    // Constructor con argumentos
    public Informe(String tipoInforme, Date fecha, String datosJson) {
        this.tipoInforme = tipoInforme;
        this.fecha = fecha;
        this.datosJson = datosJson;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipoInforme() {
        return tipoInforme;
    }

    public void setTipoInforme(String tipoInforme) {
        this.tipoInforme = tipoInforme;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDatosJson() {
        return datosJson;
    }

    public void setDatosJson(String datosJson) {
        this.datosJson = datosJson;
    }

    // Método toString para representación en texto
    @Override
    public String toString() {
        return "Informe{" +
                "id=" + id +
                ", tipoInforme='" + tipoInforme + '\'' +
                ", fecha=" + fecha +
                ", datosJson='" + datosJson + '\'' +
                '}';
    }
}
