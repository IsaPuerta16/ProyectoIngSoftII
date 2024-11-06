package com.proyectoingsoft.demo.services;

import com.proyectoingsoft.demo.models.Producto;
import com.proyectoingsoft.demo.repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> getAllProductos() {
        return productoRepository.findAll();
    }

    public Producto createProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    public Producto updateProducto(Long id, Producto producto) {
        producto.setId(id);
        return productoRepository.save(producto);
    }

    public void deleteProducto(Long id) {
        productoRepository.deleteById(id);
    }
}
