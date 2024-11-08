package com.proyectoingsoft.demo.services;

import com.proyectoingsoft.demo.models.Informe;
import com.proyectoingsoft.demo.repositories.InformeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InformeService {
    @Autowired
    private InformeRepository informeRepository;

    public List<Informe> getAllInformes() {
        return informeRepository.findAll();
    }

    public Informe getInformeById(Long id) {
        return informeRepository.findById(id).orElse(null);
    }

    public Informe createInforme(Informe informe) {
        return informeRepository.save(informe);
    }

    public Informe updateInforme(Long id, Informe informeDetails) {
        Informe informe = informeRepository.findById(id).orElse(null);
        if (informe != null) {
            informe.setTipoInforme(informeDetails.getTipoInforme());
            informe.setFecha(informeDetails.getFecha());
            informe.setDatosJson(informeDetails.getDatosJson());
            return informeRepository.save(informe);
        }
        return null;
    }

    public void deleteInforme(Long id) {
        informeRepository.deleteById(id);
    }
}
