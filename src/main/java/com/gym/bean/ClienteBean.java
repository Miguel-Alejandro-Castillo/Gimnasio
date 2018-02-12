package com.gym.bean;

import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by Alejandro on 11/2/2018.
 */
public class ClienteBean {

    @NotBlank(message = "dni.empty")
    private Long dni;
    @NotBlank(message = "nombre.empty")
    private String nombre;
    @NotBlank(message = "apellido.empty")
    private String apellido;
    @NotBlank(message = "edad.empty")
    private Short edad;
    @NotBlank(message = "telefono.empty")
    private Long telefono;

    public ClienteBean() {
        super();
    }

    
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
