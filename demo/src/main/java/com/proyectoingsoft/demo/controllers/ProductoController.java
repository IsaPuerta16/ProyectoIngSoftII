package com.proyectoingsoft.demo.controllers;

import com.proyectoingsoft.demo.models.Producto;
import com.proyectoingsoft.demo.repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {
    @Autowired
    private ProductoRepository productoRepository;

    @GetMapping
    public List<Producto> getAllProductos() {
        return productoRepository.findAll();
    }

    @PostMapping
    public Producto createProducto(@RequestBody Producto producto) {
        return productoRepository.save(producto);
    }

    @GetMapping("/{id}")
    public Producto getProductoById(@PathVariable Long id) {
        return productoRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Producto updateProducto(@PathVariable Long id, @RequestBody Producto productoDetails) {
        Producto producto = productoRepository.findById(id).orElse(null);
        if (producto != null) {
            producto.setCodigo(productoDetails.getCodigo());
            producto.setDescripcion(productoDetails.getDescripcion());
            producto.setPrecioVenta(productoDetails.getPrecioVenta());
            producto.setImpuestoId(productoDetails.getImpuestoId());
            producto.setMedida(productoDetails.getMedida());
            producto.setCategoriaId(productoDetails.getCategoriaId());
            return productoRepository.save(producto);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteProducto(@PathVariable Long id) {
        productoRepository.deleteById(id);
    }
}
