package com.gym.model;

import javax.persistence.*;
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
    private Long costo;

    @OneToMany(
            cascade = CascadeType.ALL,
            mappedBy = "producto",
            orphanRemoval = true
    )
    private Set<Venta> ventas = new HashSet<>();

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

    public Long getCosto() {
        return costo;
    }

    public void setCosto(Long costo) {
        this.costo = costo;
    }

    public Set<Venta> getVentas() {
        return ventas;
    }

    public void setVentas(Set<Venta> ventas) {
        this.ventas = ventas;
    }

    public void addVenta(Venta venta){
        ventas.add(venta);
        venta.setProducto(this);
    }

    public void removeVenta(Venta venta){
        ventas.remove(venta);
        venta.setProducto(null);
    }

    public Producto() {
    }

    public Producto(String nombre, Long costo, Set<Venta> ventas) {
        this.nombre = nombre;
        this.costo = costo;
        this.ventas = ventas;
    }
}
