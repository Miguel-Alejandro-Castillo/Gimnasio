package com.gym.bean;

import com.gym.model.Profesor;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.util.Date;

/**
 * Created by negro on 11/2/2018.
 */
public class ProfesorBean {

    private Long id;

    @NotBlank(message = "{campo.obligatorio}")
    private String nombre;
    @NotBlank(message = "{campo.obligatorio}")
    private String apellido;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "{campo.fecha_de_nacimiento.vacio}" )
    @Past(message = "{campo.fecha_de_nacimiento.pasado}" )
    private Date fecha_de_nacimiento;
    @NotBlank(message = "{campo.obligatorio}")
    private String telefono;
    @NotBlank(message = "{campo.obligatorio}")
    private String direccion;
    @Email(message = "{campo.email.incorrecto}" )
    private String email;

    public ProfesorBean() {
        super();
    }

    public ProfesorBean(Long id, String nombre, String apellido, Date fecha_de_nacimiento, String telefono, String direccion, String email) {
        this();
        this.id = id;
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

    public void load(Profesor profesor) {
        this.setId(profesor.getId());
        this.setNombre(profesor.getNombre());
        this.setApellido(profesor.getApellido());
        this.setFecha_de_nacimiento(profesor.getFecha_de_nacimiento());
        this.setTelefono(profesor.getTelefono());
        this.setDireccion(profesor.getDireccion());
        this.setEmail(profesor.getEmail());
    }
}
