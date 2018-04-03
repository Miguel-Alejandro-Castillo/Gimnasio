package com.gym.model;

import com.gym.bean.ClienteBean;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;

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

    @Column(nullable = false, unique = true)
    private  Long dni;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fecha_de_nacimiento;

    @Column(nullable = false)
    private String telefono;


    @Column(nullable = false)
    private String direccion;

    @Column
    private String email;

    @OneToMany( fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, orphanRemoval = true)
    private Set<Pago> pagos;

    public Cliente() {
        super();
    }

    public Cliente(Long id,String nombre, String apellido, Long dni,Date fecha_de_nacimiento, String telefono, String direccion, String email) {
        this();
        this.id=id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fecha_de_nacimiento = fecha_de_nacimiento;
        this.telefono = telefono;
        this.direccion = direccion;
        this.email = email;
    }
    public Cliente(ClienteBean clienteBean){
        this();
        this.id=clienteBean.getId();
        this.nombre = clienteBean.getNombre();
        this.apellido = clienteBean.getApellido();
        this.dni = clienteBean.getDni();
        this.fecha_de_nacimiento = clienteBean.getFecha_de_nacimiento();
        this.telefono = clienteBean.getTelefono();
        this.direccion = clienteBean.getDireccion();
        this.email = clienteBean.getEmail();
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

	public Set<Pago> getPagos(){
		return pagos;
	}
    
	public void setPagos(Set<Pago> pagos) {
		this.pagos = pagos;
	}
    
}
