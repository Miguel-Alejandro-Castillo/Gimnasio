package com.gym.model;

import javax.persistence.*;
/**
 * Created by Alejandro on 10/2/2018.
 */
@Entity
@Table( name = "CLIENTE")
public class Cliente {
    @Column(nullable = false)
    private Long dni;
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private String apellido;
    @Column(nullable = false)
    private Short edad;
    @Column(nullable = false)
    private Long telefono;

    public Long getDNI() {
        return dni;
    }

    public void setDNI(Long id) {
        this.dni = dni;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Short getEdad() {
        return edad;
    }

    public void setEdad(Short edad) {
        this.edad = edad;
    }

    public Long getTelefono() {
        return telefono;
    }

    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }
}
