package com.gym.model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import javax.validation.constraints.NegativeOrZero;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Alejandro on 10/2/2018.
 */
@Entity
@Table( name = "clientes")
public class Cliente extends BaseEntity{

    @NotBlank(message = "{campo.obligatorio}")
    @Column(nullable = false)
    private String nombre;

    @NotBlank(message = "{campo.obligatorio}")
    @Column(nullable = false)
    private String apellido;

    @NotBlank(message = "{campo.obligatorio}")
    @Column(nullable = false)
    private String sexo;

    @NotNull(message = "{campo.obligatorio}")
    @Column(nullable = false, unique = true)
    private  Long dni;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "{campo.obligatorio}")
    @Past(message = "{campo.fecha_de_nacimiento.pasado}" )
    @Column(nullable = false)
    private Date fechaNacimiento;

    @NotBlank(message = "{campo.obligatorio}")
    @Column(nullable = false)
    private String telefono;

    @NotBlank(message = "{campo.obligatorio}")
    @Column(nullable = false)
    private String direccion;

    @Email(message = "{campo.email.incorrecto}" )
    @Column
    private String email;

    @OneToMany( fetch = FetchType.EAGER, cascade = CascadeType.ALL , orphanRemoval = true)
    private Set<Pago> pagos = new HashSet<Pago>();

    public Cliente() {
        super();
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

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento( Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public  Long getDni() {
        return dni;
    }

    public void setDni(Long dni) {
        this.dni = dni;
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

    public Set<Pago> getPagos() {
        return pagos;
    }

    public void setPagos(Set<Pago> pagos) {
        this.pagos = pagos;
    }
}
