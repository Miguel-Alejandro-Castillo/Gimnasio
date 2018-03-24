package com.gym.bean;

import com.gym.model.Cliente;
import com.gym.model.Pago;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NegativeOrZero;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.util.Date;
import java.util.Set;

/**
 * Created by Alejandro on 11/2/2018.
 */
public class ClienteBean {

    private Long id;

    @NotBlank(message = "{campo.obligatorio}")
    private String nombre;
    @NotBlank(message = "{campo.obligatorio}")
    private String apellido;

    @NotNull
    @NegativeOrZero
    private Long dni;

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
    private Set<Pago> pagos;
    public ClienteBean() {
        super();
    }

    public ClienteBean(Long id, String nombre, String apellido, Date fecha_de_nacimiento, String telefono, String direccion, String email) {
        this();
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecha_de_nacimiento = fecha_de_nacimiento;
        this.telefono = telefono;
        this.direccion = direccion;
        this.email = email;
    }
    public ClienteBean(Cliente cliente){
        this();
        this.id=cliente.getId();
        this.nombre = cliente.getNombre();
        this.apellido = cliente.getApellido();
        this.dni = cliente.getDni();
        this.fecha_de_nacimiento = cliente.getFecha_de_nacimiento();
        this.telefono = cliente.getTelefono();
        this.direccion = cliente.getDireccion();
        this.email = cliente.getEmail();
        this.pagos = cliente.getPagos();
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

    public Long getDni() {
        return dni;
    }

    public void setDni(Long dni) {
        this.dni = dni;
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

    public Set<Pago> getPagos() {
        return pagos;
    }

    public void setPagos(Set<Pago> pagos) {
        this.pagos = pagos;
    }

    private  void load(Cliente cliente) {
        this.setId(cliente.getId());
        this.setNombre(cliente.getNombre());
        this.setApellido(cliente.getApellido());
        this.setDni(cliente.getDni());
        this.setFecha_de_nacimiento(cliente.getFecha_de_nacimiento());
        this.setTelefono(cliente.getTelefono());
        this.setDireccion(cliente.getDireccion());
        this.setEmail(cliente.getEmail());
    }
}
