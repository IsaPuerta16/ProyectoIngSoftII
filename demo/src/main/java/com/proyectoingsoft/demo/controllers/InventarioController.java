package com.proyectoingsoft.demo.controllers;

import com.proyectoingsoft.demo.models.Inventario;
import com.proyectoingsoft.demo.repositories.InventarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventarios")
public class InventarioController {
    @Autowired
    private InventarioRepository inventarioRepository;

    @GetMapping
    public List<Inventario> getAllInventarios() {
        return inventarioRepository.findAll();
    }

    @PostMapping
    public Inventario createInventario(@RequestBody Inventario inventario) {
        return inventarioRepository.save(inventario);
    }

    @GetMapping("/{id}")
    public Inventario getInventarioById(@PathVariable Long id) {
        return inventarioRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Inventario updateInventario(@PathVariable Long id, @RequestBody Inventario inventarioDetails) {
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

    @DeleteMapping("/{id}")
    public void deleteInventario(@PathVariable Long id) {
        inventarioRepository.deleteById(id);
    }
}
