package com.proyectoingsoft.demo.services;

import com.proyectoingsoft.demo.models.Inventario;
import com.proyectoingsoft.demo.repositories.InventarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventarioService {
    @Autowired
    private InventarioRepository inventarioRepository;

    public List<Inventario> getAllInventarios() {
        return inventarioRepository.findAll();
    }

    public Inventario getInventarioById(Long id) {
        return inventarioRepository.findById(id).orElse(null);
    }

    public Inventario createInventario(Inventario inventario) {
        return inventarioRepository.save(inventario);
    }

    public Inventario updateInventario(Long id, Inventario inventarioDetails) {
        Inventario inventario = inventarioRepository.findById(id).orElse(null);
        if (inventario != null) {
            inventario.setFecha(inventarioDetails.getFecha());
            inventario.setTipoMovimiento(inventarioDetails.getTipoMovimiento());
            inventario.setEntrada(inventarioDetails.getEntrada());
            inventario.setSalida(inventarioDetails.getSalida());
            inventario.setObservaciones(inventarioDetails.getObservaciones());
            inventario.setIdProducto(inventarioDetails.getIdProducto());
            return inventarioRepository.save(inventario);
        }
        return null;
    }

    public void deleteInventario(Long id) {
        inventarioRepository.deleteById(id);
    }
}
