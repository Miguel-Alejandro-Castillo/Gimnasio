package com.gym.model;

import javax.persistence.*;

import org.hibernate.validator.constraints.NotBlank;

import java.util.Date;
import java.util.Set;

/**
 * @author negro
 *
 */
@Entity
@Table( name = "profesores")
public class Profesor {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellido;

    @NotBlank(message = "{campo.obligatorio}")
    @Column(nullable = false)
    private String sexo;
    
	@Column(nullable = false, unique = true)
	private  Long dni;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;

    @Column(nullable = false)
    private String telefono;

    @Column(nullable = false)
    private String direccion;

    @Column

    private String email;

	public Profesor() {
		super();
	}

    public Profesor(String sexo,Long id, Long dni, String nombre, String apellido, Date fecha_de_nacimiento, String telefono, String direccion, String email) {
		this();
		this.sexo = sexo;
	    this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fecha_de_nacimiento;
		this.telefono = telefono;
		this.direccion = direccion;
		this.email = email;
		this.dni = dni;
	}


	public Long getDni() {
		return dni;
	}


	public void setDni(Long dni) {
		this.dni = dni;
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
		return fechaNacimiento;
	}


	public void setFecha_de_nacimiento(Date fecha_de_nacimiento) {
		this.fechaNacimiento = fecha_de_nacimiento;
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

	@Override
	public String toString() {
		return this.getNombre() + " " +this.getApellido()+ " - "+this.getDni();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Profesor)) return false;

		Profesor profesor = (Profesor) o;

		if (apellido != null ? !apellido.equals(profesor.apellido) : profesor.apellido != null) return false;
		if (direccion != null ? !direccion.equals(profesor.direccion) : profesor.direccion != null) return false;
		if (dni != null ? !dni.equals(profesor.dni) : profesor.dni != null) return false;
		if (email != null ? !email.equals(profesor.email) : profesor.email != null) return false;
		if (fechaNacimiento != null ? !fechaNacimiento.equals(profesor.fechaNacimiento) : profesor.fechaNacimiento != null)
			return false;
		if (id != null ? !id.equals(profesor.id) : profesor.id != null) return false;
		if (nombre != null ? !nombre.equals(profesor.nombre) : profesor.nombre != null) return false;
		if (telefono != null ? !telefono.equals(profesor.telefono) : profesor.telefono != null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = (id != null ? id.hashCode() : 0);
		result = 31 * result + (nombre != null ? nombre.hashCode(): 0);
		result = 31 * result + ( apellido != null ? apellido.hashCode(): 0);
		result = 31 * result + (dni != null ? dni.hashCode(): 0);
		result = 31 * result + (fechaNacimiento != null ? fechaNacimiento.hashCode() : 0);
		result = 31 * result + (telefono != null ? telefono.hashCode() : 0) ;
		result = 31 * result + (direccion != null ? direccion.hashCode() :0);
		result = 31 * result + (email != null ? email.hashCode(): 0);
		return result;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
}
