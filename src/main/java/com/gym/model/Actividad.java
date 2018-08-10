package com.gym.model;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Javier on 10/2/2018.
 */
@Entity
@Table( name = "actividades")
public class Actividad {

	@Id
	//@NotNull(message = "{campo.obligatorio}")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;    
    
	@NotNull(message = "{campo.obligatorio}")
	@Column(nullable = false, unique = true)
    private String nombre;

    @Column(nullable = false)
    private BigDecimal costo;

    @OneToOne//(fetch = FetchType.EAGER, cascade = CascadeType.ALL) //si se borra
    private Profesor profesor;
   
    @OneToMany(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, orphanRemoval = true)
	private Set<Leccion> lecciones;

    public Actividad() {
    	super();
		lecciones = new HashSet<>();
    }
    
    public Actividad(Long id, String nombre, BigDecimal costo, Profesor profesor) {
		this();
		this.id = id;
		this.nombre = nombre;
		this.costo = costo;
		this.profesor = profesor;
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
	public BigDecimal getCosto() {
		return costo;
	}
	public void setCosto(BigDecimal costo) {
		this.costo = costo;
	}

	public Set<Leccion> getLecciones() {
		return lecciones;
	}

	public void setLecciones(Set<Leccion> lecciones) {
		this.lecciones = lecciones;
	}

	@Override
	public String toString() { return  this.getNombre();}
	
	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}
	
	public String getActividadProfesor() {
		return this.getNombre()+" -- "+this.getProfesor().getNombre()+' '+this.getProfesor().getApellido();
	}
	
}