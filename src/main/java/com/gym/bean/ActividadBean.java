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

	private Dia newDia;
	private Long newHorario;
	private Long newProfesor;
    private Set<DiaHorarioProfesor> diasHorariosProfesores;
	public ActividadBean() {
		super();
		this.diasHorariosProfesores = new HashSet<DiaHorarioProfesor>(0);
	}

	public ActividadBean(Long id, String nombre, BigDecimal costo) {
		this();
		this.id = id;
		this.nombre = nombre;
		this.costo = costo;
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

	public Long getNewProfesor() {
		return newProfesor;
	}

	public void setNewProfesor(Long newProfesor) {
		this.newProfesor = newProfesor;
	}

	public Set<DiaHorarioProfesor> getDiasHorariosProfesores() {
		return diasHorariosProfesores;
	}

	public void setDiasHorariosProfesores(Set<DiaHorarioProfesor> diasHorariosProfesores) {
		this.diasHorariosProfesores = diasHorariosProfesores;
	}

	public void load(Actividad actividad) {
        this.setId(actividad.getId());
		this.setNombre(actividad.getNombre());
		this.setCosto(actividad.getCosto());
		this.setDiasHorariosProfesores(actividad.getDiasHorariosProfesores());
    }
	@Override
	public String toString() { return  this.getNombre();}
    
}