package com.proyectoingsoft.demo.services;

import com.proyectoingsoft.demo.models.Impuesto;
import com.proyectoingsoft.demo.repositories.ImpuestoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImpuestoService {
    @Autowired
    private ImpuestoRepository impuestoRepository;

    public List<Impuesto> getAllImpuestos() {
        return impuestoRepository.findAll();
    }

    public Impuesto getImpuestoById(Long id) {
        return impuestoRepository.findById(id).orElse(null);
    }

    public Impuesto createImpuesto(Impuesto impuesto) {
        return impuestoRepository.save(impuesto);
    }

    public Impuesto updateImpuesto(Long id, Impuesto impuestoDetails) {
        Impuesto impuesto = impuestoRepository.findById(id).orElse(null);
        if (impuesto != null) {
            impuesto.setNombre(impuestoDetails.getNombre());
            impuesto.setPorcentaje(impuestoDetails.getPorcentaje());
            return impuestoRepository.save(impuesto);
        }
        return null;
    }

    public void deleteImpuesto(Long id) {
        impuestoRepository.deleteById(id);
    }
}
