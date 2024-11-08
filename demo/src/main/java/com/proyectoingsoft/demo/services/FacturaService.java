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

    public Factura getFacturaById(Long id) {
        return facturaRepository.findById(id).orElse(null);
    }

    public Factura createFactura(Factura factura) {
        return facturaRepository.save(factura);
    }

    public Factura updateFactura(Long id, Factura facturaDetails) {
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

    public void deleteFactura(Long id) {
        facturaRepository.deleteById(id);
    }
}
