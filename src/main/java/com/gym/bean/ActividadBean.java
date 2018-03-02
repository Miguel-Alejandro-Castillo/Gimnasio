package com.gym.bean;

import com.gym.model.Actividad;

/**
 * Created by Alejandro on 11/2/2018.
 */
public class ActividadBean {

	private Long id;
    private String nombreActividad;
    private String profesor;
    private Integer costo;
    private String dia;
    
    public ActividadBean(Long id, String nombreActividad, String profesor, Integer costo, String dia) {
		super();
		this.id = id;
		this.nombreActividad = nombreActividad;
		this.profesor = profesor;
		this.costo = costo;
		this.dia = dia;
	}
    
    public ActividadBean() {
    	super();
    }

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombreActividad() {
		return nombreActividad;
	}
	public void setNombreActividad(String nombreActividad) {
		this.nombreActividad = nombreActividad;
	}
	public String getProfesor() {
		return profesor;
	}
	public void setProfesor(String profesor) {
		this.profesor = profesor;
	}
	public Integer getCosto() {
		return costo;
	}
	public void setCosto(Integer costo) {
		this.costo = costo;
	}
	public String getDia() {
		return dia;
	}
	public void setDia(String dia) {
		this.dia = dia;
	} 
	public void load(Actividad actividad) {
        this.setId(actividad.getId());
		this.setNombreActividad(actividad.getNombreActividad());
		this.setProfesor(actividad.getProfesor());
		this.setCosto(actividad.getCosto());
		this.setDia(actividad.getDia());
    }
    
}