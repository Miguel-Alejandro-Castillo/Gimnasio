package com.gym.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Alejandro on 10/2/2018.
 */
@Entity
@Table( name = "CLIENTES")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellido;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fecha_de_nacimiento;

    @Column(nullable = false)
    private String telefono;

    @Column(nullable = false)
    private String direccion;

    @Column
    private String email;

    public Cliente() {
        super();
    }

    public Cliente(Long id,String nombre, String apellido, Date fecha_de_nacimiento, String telefono, String direccion, String email) {
        this();
        this.id=id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecha_de_nacimiento = fecha_de_nacimiento;
        this.telefono = telefono;
        this.direccion = direccion;
        this.email = email;
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFecha_de_nacimiento() {
        return fecha_de_nacimiento;
    }

    public void setFecha_de_nacimiento(Date fecha_de_nacimiento) {
        this.fecha_de_nacimiento = fecha_de_nacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
