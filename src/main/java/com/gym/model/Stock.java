package com.gym.model;

/**
 * Created by Alejandro on 29/1/2019.
 */

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table( name = "stocks")
public class Stock extends BaseEntity {

    @NotNull
    @Column
    private Date fechaIngreso;

    @NotNull
    @Column
    private Integer cantidadRecibida;

    @NotNull
    @Column
    private Integer cantidadActual;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE})
    @JoinColumn(name = "producto_id")
    private Producto producto;

    public Stock(){

    }

    public Stock(Date fechaIngreso, Integer cantidadRecibida, Integer cantidadActual, Producto producto) {
        this.fechaIngreso = fechaIngreso;
        this.cantidadRecibida = cantidadRecibida;
        this.cantidadActual = cantidadActual;
        this.producto = producto;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Integer getCantidadRecibida() {
        return cantidadRecibida;
    }

    public void setCantidadRecibida(Integer cantidadRecibida) {
        this.cantidadRecibida = cantidadRecibida;
    }

    public Integer getCantidadActual() {
        return cantidadActual;
    }

    public void setCantidadActual(Integer cantidadActual) {
        this.cantidadActual = cantidadActual;
    }
}
