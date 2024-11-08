package com.proyectoingsoft.demo.controllers;

import com.proyectoingsoft.demo.models.MetodoPago;
import com.proyectoingsoft.demo.repositories.MetodoPagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/metodos-pago")
public class MetodoPagoController {
    @Autowired
    private MetodoPagoRepository metodoPagoRepository;

    @GetMapping
    public List<MetodoPago> getAllMetodosPago() {
        return metodoPagoRepository.findAll();
    }

    @PostMapping
    public MetodoPago createMetodoPago(@RequestBody MetodoPago metodoPago) {
        return metodoPagoRepository.save(metodoPago);
    }

    @GetMapping("/{id}")
    public MetodoPago getMetodoPagoById(@PathVariable Long id) {
        return metodoPagoRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public MetodoPago updateMetodoPago(@PathVariable Long id, @RequestBody MetodoPago metodoPagoDetails) {
        MetodoPago metodoPago = metodoPagoRepository.findById(id).orElse(null);
        if (metodoPago != null) {
            metodoPago.setDescripcion(metodoPagoDetails.getDescripcion());
            metodoPago.setIdentificador(metodoPagoDetails.getIdentificador());
            return metodoPagoRepository.save(metodoPago);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteMetodoPago(@PathVariable Long id) {
        metodoPagoRepository.deleteById(id);
    }
}
