package com.proyectoingsoft.demo.services;

import com.proyectoingsoft.demo.models.Factura;
import com.proyectoingsoft.demo.repositories.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacturaService {

    @Autowired
    private FacturaRepository facturaRepository;

    public List<Factura> getAllFacturas() {
        return facturaRepository.findAll();
    }

    public Factura createFactura(Factura factura) {
        return facturaRepository.save(factura);
    }

    public Factura updateFactura(Long id, Factura factura) {
        factura.setId(id);
        return facturaRepository.save(factura);
    }

    public void deleteFactura(Long id) {
        facturaRepository.deleteById(id);
    }
}
