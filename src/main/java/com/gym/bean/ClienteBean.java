package com.gym.bean;

import com.gym.model.Cliente;
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
 * Created by Alejandro on 11/2/2018.
 */
public class ClienteBean {

    private Long id;

    @NotBlank
    private String nombre;
    @NotBlank
    private String apellido;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "No se ingreso una fecha de nacimiento" )
    @Past
    private Date fecha_de_nacimiento;
    @NotBlank
    private String telefono;
    @NotBlank
    private String direccion;
    @Email
    private String email;
    private String facebook;

    public ClienteBean() {
        super();
    }

    public ClienteBean(Long id, String nombre, String apellido, Date fecha_de_nacimiento, String telefono, String direccion, String email, String facebook) {
        this();
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecha_de_nacimiento = fecha_de_nacimiento;
        this.telefono = telefono;
        this.direccion = direccion;
        this.email = email;
        this.facebook = facebook;
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

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public void load(Cliente cliente) {
        this.setId(cliente.getId());
        this.setNombre(cliente.getNombre());
        this.setApellido(cliente.getApellido());
        this.setFecha_de_nacimiento(cliente.getFecha_de_nacimiento());
        this.setTelefono(cliente.getTelefono());
        this.setDireccion(cliente.getDireccion());
        this.setEmail(cliente.getEmail());
        this.setFacebook(cliente.getFacebook());
    }
}
