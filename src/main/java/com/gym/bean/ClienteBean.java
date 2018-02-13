package com.gym.bean;

import com.gym.model.Cliente;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * Created by Alejandro on 11/2/2018.
 */
public class ClienteBean {
    private Long id;
    @NotNull
    private Long dni;
    @NotBlank
    private String nombre;
    @NotBlank
    private String apellido;
    @NotNull
    private Short edad;
    @NotNull
    private Long telefono;

    public ClienteBean() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDni() {
        return dni;
    }

    public void setDni(Long dni) {
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

    public void load(Cliente cliente) {
        this.setId(cliente.getId());
        this.setApellido(cliente.getApellido());
        this.setDni(cliente.getDni());
        this.setEdad(cliente.getEdad());
        this.setNombre(cliente.getNombre());
        this.setTelefono(cliente.getTelefono());
    }
}
