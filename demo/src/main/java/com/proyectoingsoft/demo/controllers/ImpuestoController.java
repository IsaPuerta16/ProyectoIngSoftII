package com.proyectoingsoft.demo.controllers;

import com.proyectoingsoft.demo.models.Impuesto;
import com.proyectoingsoft.demo.repositories.ImpuestoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/impuestos")
public class ImpuestoController {
    @Autowired
    private ImpuestoRepository impuestoRepository;

    @GetMapping
    public List<Impuesto> getAllImpuestos() {
        return impuestoRepository.findAll();
    }

    @PostMapping
    public Impuesto createImpuesto(@RequestBody Impuesto impuesto) {
        return impuestoRepository.save(impuesto);
    }

    @GetMapping("/{id}")
    public Impuesto getImpuestoById(@PathVariable Long id) {
        return impuestoRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Impuesto updateImpuesto(@PathVariable Long id, @RequestBody Impuesto impuestoDetails) {
        Impuesto impuesto = impuestoRepository.findById(id).orElse(null);
        if (impuesto != null) {
            impuesto.setNombre(impuestoDetails.getNombre());
            impuesto.setPorcentaje(impuestoDetails.getPorcentaje());
            return impuestoRepository.save(impuesto);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteImpuesto(@PathVariable Long id) {
        impuestoRepository.deleteById(id);
    }
}
