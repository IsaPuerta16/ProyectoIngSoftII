package com.proyectoingsoft.demo.controllers;

import com.proyectoingsoft.demo.models.Informe;
import com.proyectoingsoft.demo.repositories.InformeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/informes")
public class InformeController {
    @Autowired
    private InformeRepository informeRepository;

    @GetMapping
    public List<Informe> getAllInformes() {
        return informeRepository.findAll();
    }

    @PostMapping
    public Informe createInforme(@RequestBody Informe informe) {
        return informeRepository.save(informe);
    }

    @GetMapping("/{id}")
    public Informe getInformeById(@PathVariable Long id) {
        return informeRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Informe updateInforme(@PathVariable Long id, @RequestBody Informe informeDetails) {
        Informe informe = informeRepository.findById(id).orElse(null);
        if (informe != null) {
            informe.setTipoInforme(informeDetails.getTipoInforme());
            informe.setFecha(informeDetails.getFecha());
            informe.setDatosJson(informeDetails.getDatosJson());
            return informeRepository.save(informe);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteInforme(@PathVariable Long id) {
        informeRepository.deleteById(id);
    }
}
