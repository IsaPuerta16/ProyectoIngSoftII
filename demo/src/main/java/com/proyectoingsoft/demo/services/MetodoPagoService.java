package com.proyectoingsoft.demo.services;

import com.proyectoingsoft.demo.models.MetodoPago;
import com.proyectoingsoft.demo.repositories.MetodoPagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MetodoPagoService {
    @Autowired
    private MetodoPagoRepository metodoPagoRepository;

    public List<MetodoPago> getAllMetodosPago() {
        return metodoPagoRepository.findAll();
    }

    public MetodoPago getMetodoPagoById(Long id) {
        return metodoPagoRepository.findById(id).orElse(null);
    }

    public MetodoPago createMetodoPago(MetodoPago metodoPago) {
        return metodoPagoRepository.save(metodoPago);
    }

    public MetodoPago updateMetodoPago(Long id, MetodoPago metodoPagoDetails) {
        MetodoPago metodoPago = metodoPagoRepository.findById(id).orElse(null);
        if (metodoPago != null) {
            metodoPago.setDescripcion(metodoPagoDetails.getDescripcion());
            metodoPago.setIdentificador(metodoPagoDetails.getIdentificador());
            return metodoPagoRepository.save(metodoPago);
        }
        return null;
    }

    public void deleteMetodoPago(Long id) {
        metodoPagoRepository.deleteById(id);
    }
}
