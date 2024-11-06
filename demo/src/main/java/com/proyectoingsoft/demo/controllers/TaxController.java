package com.proyectoingsoft.demo.controllers;

import com.proyectoingsoft.demo.models.Tax;
import com.proyectoingsoft.demo.services.TaxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/taxes")
public class TaxController {

    @Autowired
    private TaxService taxService;

    @GetMapping
    public List<Tax> getAllTaxes() {
        return taxService.getAllTaxes();
    }

    @PostMapping
    public Tax createTax(@RequestBody Tax tax) {
        return taxService.createTax(tax);
    }

    @PutMapping("/{id}")
    public Tax updateTax(@PathVariable Long id, @RequestBody Tax tax) {
        return taxService.updateTax(id, tax);
    }

    @DeleteMapping("/{id}")
    public void deleteTax(@PathVariable Long id) {
        taxService.deleteTax(id);
    }
}
