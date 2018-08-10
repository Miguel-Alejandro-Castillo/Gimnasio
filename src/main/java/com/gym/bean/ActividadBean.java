package com.gym.bean;

import com.gym.model.*;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NegativeOrZero;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Alejandro on 11/2/2018.
 */
public class ActividadBean {

	private Long id;

	@NotBlank(message = "{campo.obligatorio}")
    private String nombre;

	@NegativeOrZero @NotNull
	private  BigDecimal costo;
	
	@NotNull
	private Profesor profesor;

	private Dia newDia;
	private Long newHorario;;
    private Set<Leccion> lecciones;
    
	public ActividadBean() {
		super();
		this.lecciones = new HashSet<Leccion>(0);
	}

	public ActividadBean(Long id, String nombre, BigDecimal costo, Profesor profesor) {
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
	
	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	public Dia getNewDia() {
		return newDia;
	}

	public void setNewDia(Dia newDia) {
		this.newDia = newDia;
	}

	public Long getNewHorario() {
		return newHorario;
	}

	public void setNewHorario(Long newHorario) {
		this.newHorario = newHorario;
	}
	
	public Set<Leccion> getLecciones() {
		return lecciones;
	}

	public void setLecciones(Set<Leccion> lecciones) {
		this.lecciones = lecciones;
	}

	public void load(Actividad actividad) {
        this.setId(actividad.getId());
		this.setNombre(actividad.getNombre());
		this.setCosto(actividad.getCosto());
		this.setProfesor(actividad.getProfesor());
		this.setLecciones(actividad.getLecciones());
    }
	@Override
	public String toString() { return  this.getNombre();}
    
}