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

    public Producto getProductoById(Long id) {
        return productoRepository.findById(id).orElse(null);
    }

    public Producto createProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    public Producto updateProducto(Long id, Producto productoDetails) {
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

    public void deleteProducto(Long id) {
        productoRepository.deleteById(id);
    }
}
