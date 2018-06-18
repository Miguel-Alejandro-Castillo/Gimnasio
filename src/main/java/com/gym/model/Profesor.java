package com.gym.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

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
	@NotNull(message = "{campo.obligatorio}" )
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

	public Profesor() {
		super();
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

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Long getDni() {
		return dni;
	}

	public void setDni(Long dni) {
		this.dni = dni;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
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
