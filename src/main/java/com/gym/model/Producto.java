package com.gym.model;

import org.springframework.data.repository.cdi.Eager;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "producto")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "costo")
    private BigDecimal costo;

    private Integer stockActual;

    @OneToMany(
            cascade = CascadeType.ALL,
            mappedBy = "producto",
            orphanRemoval = true
    )
    private Set<Venta> ventas;

    @OneToMany(
            mappedBy = "producto",
            cascade = {CascadeType.MERGE,CascadeType.REMOVE},
            orphanRemoval = true,
            fetch = FetchType.EAGER
    )
    private Set<Stock> stocks;

    @Column(name = "borrado", nullable = false)
    private boolean borrado;

    public Producto() {
        super();
        this.ventas = new HashSet<>();
        this.stocks= new HashSet<>();
        this.borrado = false;
    }

    public Producto(String nombre, BigDecimal costo, Integer stockActual, Set<Venta> ventas, Set<Stock> stocks, boolean borrado) {
        this.nombre = nombre;
        this.costo = costo;
        this.stockActual = stockActual;
        this.ventas = ventas;
        this.stocks = stocks;
        this.borrado = borrado;
    }

    public Integer getStockActual() {
        return stockActual;
    }

    public void setStockActual(Integer stockActual) {
        this.stockActual = stockActual;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigDecimal getCosto() {
        return costo;
    }

    public void setCosto(BigDecimal costo) {
        this.costo = costo;
    }

    public Set<Venta> getVentas() {
        return ventas;
    }

    public void setVentas(Set<Venta> ventas) {
        this.ventas = ventas;
    }

    public boolean isBorrado() {
        return borrado;
    }

    public void setBorrado(boolean borrado) {
        this.borrado = borrado;
    }

    public void addVenta(Venta venta){
        ventas.add(venta);
        venta.setProducto(this);
    }

    public void removeVenta(Venta venta){
        ventas.remove(venta);
        venta.setProducto(null);
    }

    public Set<Stock> getStocks() {
        return stocks;
    }

    public void setStocks(Set<Stock> stocks) {
        this.stocks = stocks;
    }
}
