package com.proyectoingsoft.demo.models;

import jakarta.persistence.*;
import java.util.List;

import ch.qos.logback.core.net.server.Client;

@Entity
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @OneToMany(mappedBy = "invoice", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Producto> products;

    @Column(nullable = false)
    private Double total;

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Producto> getProducts() {
        return products;
    }

    public void setProducts(List<Producto> products) {
        this.products = products;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
