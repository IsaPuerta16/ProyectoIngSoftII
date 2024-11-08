package com.proyectoingsoft.demo.controllers;

import com.proyectoingsoft.demo.models.Factura;
import com.proyectoingsoft.demo.repositories.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/facturas")
public class FacturaController {
    @Autowired
    private FacturaRepository facturaRepository;

    @GetMapping
    public List<Factura> getAllFacturas() {
        return facturaRepository.findAll();
    }

    @PostMapping
    public Factura createFactura(@RequestBody Factura factura) {
        return facturaRepository.save(factura);
    }

    @GetMapping("/{id}")
    public Factura getFacturaById(@PathVariable Long id) {
        return facturaRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Factura updateFactura(@PathVariable Long id, @RequestBody Factura facturaDetails) {
        Factura factura = facturaRepository.findById(id).orElse(null);
        if (factura != null) {
            factura.setCodigo(facturaDetails.getCodigo());
            factura.setFecha(facturaDetails.getFecha());
            factura.setSubtotal(facturaDetails.getSubtotal());
            factura.setTotalImpuestos(facturaDetails.getTotalImpuestos());
            factura.setTotal(facturaDetails.getTotal());
            factura.setEstado(facturaDetails.getEstado());
            factura.setIdCliente(facturaDetails.getIdCliente());
            factura.setIdMetodoPago(facturaDetails.getIdMetodoPago());
            return facturaRepository.save(factura);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteFactura(@PathVariable Long id) {
        facturaRepository.deleteById(id);
    }
}
