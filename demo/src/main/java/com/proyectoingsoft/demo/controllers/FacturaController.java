package com.proyectoingsoft.demo.controllers;

import com.proyectoingsoft.demo.models.Factura;
import com.proyectoingsoft.demo.services.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/facturas")
public class FacturaController {

    @Autowired
    private FacturaService facturaService;

    @GetMapping
    public List<Factura> getAllFacturas() {
        return facturaService.getAllFacturas();
    }

    @PostMapping
    public Factura createFactura(@RequestBody Factura factura) {
        return facturaService.createFactura(factura);
    }

    @PutMapping("/{id}")
    public Factura updateFactura(@PathVariable Long id, @RequestBody Factura factura) {
        return facturaService.updateFactura(id, factura);
    }

    @DeleteMapping("/{id}")
    public void deleteFactura(@PathVariable Long id) {
        facturaService.deleteFactura(id);
    }
}
