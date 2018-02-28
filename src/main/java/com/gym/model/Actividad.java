package com.gym.model;

import javax.persistence.*;
/**
 * Created by Javier on 10/2/2018.
 */
@Entity
@Table( name = "ACTIVIDADES")
public class Actividad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;    
    
	@Column(nullable = false)
    private String nombreActividad;
	
    @Column(nullable = false)
    private String profesor;
    
    @Column(nullable = false)
    private Integer costo;
    
    @Column(nullable = false)
    private String dia;
    
    public Actividad() {
    	super();
    }
    
    public Actividad(Long id, String nombreActividad, String profesor, Integer costo, String dia) {
		this.id = id;
		this.nombreActividad = nombreActividad;
		this.profesor = profesor;
		this.costo = costo;
		this.dia = dia;
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
}