package com.proyectoingsoft.demo.services;

import com.proyectoingsoft.demo.models.Invoice;
import com.proyectoingsoft.demo.repositories.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    public List<Invoice> getAllInvoices() {
        return invoiceRepository.findAll();
    }

    public Invoice createInvoice(Invoice invoice) {
        return invoiceRepository.save(invoice);
    }

    public Invoice updateInvoice(Long id, Invoice invoice) {
        Optional<Invoice> existingInvoice = invoiceRepository.findById(id);
        if (existingInvoice.isPresent()) {
            Invoice updatedInvoice = existingInvoice.get();
            updatedInvoice.setClient(invoice.getClient());
            updatedInvoice.setTotal(invoice.getTotal());
            updatedInvoice.setProducts(invoice.getProducts());  // Asegúrate de que getProducts existe en el modelo
            return invoiceRepository.save(updatedInvoice);
        } else {
            throw new RuntimeException("Invoice not found with id " + id);
        }
    }

    public void deleteInvoice(Long id) {
        invoiceRepository.deleteById(id);
    }
}
