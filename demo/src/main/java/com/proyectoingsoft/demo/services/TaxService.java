package com.proyectoingsoft.demo.services;

import com.proyectoingsoft.demo.models.Tax;
import com.proyectoingsoft.demo.repositories.TaxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaxService {

    @Autowired
    private TaxRepository taxRepository;

    public List<Tax> getAllTaxes() {
        return taxRepository.findAll();
    }

    public Tax createTax(Tax tax) {
        return taxRepository.save(tax);
    }

    public Tax updateTax(Long id, Tax tax) {
        Optional<Tax> existingTax = taxRepository.findById(id);
        if (existingTax.isPresent()) {
            Tax updatedTax = existingTax.get();
            updatedTax.setName(tax.getName());
            updatedTax.setRate(tax.getRate());
            return taxRepository.save(updatedTax);
        } else {
            throw new RuntimeException("Tax not found with id " + id);
        }
    }

    public void deleteTax(Long id) {
        taxRepository.deleteById(id);
    }
}
