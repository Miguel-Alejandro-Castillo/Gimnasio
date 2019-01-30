package com.gym.model;

import javax.persistence.*;
import java.math.BigDecimal;
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

    @OneToMany(
            cascade = CascadeType.ALL,
            mappedBy = "producto",
            orphanRemoval = true
    )
    private Set<Venta> ventas;

    @OneToMany(
            mappedBy = "producto",
            cascade = CascadeType.ALL,
            orphanRemoval = true
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

    public Producto(String nombre, BigDecimal costo, Set<Venta> ventas, boolean borrado, Set<Stock> stocks) {
        this();
        this.nombre = nombre;
        this.costo = costo;
        this.ventas = ventas;
        this.borrado = borrado;
        this.stocks = stocks;
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
