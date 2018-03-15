package com.gym.bean;

import com.gym.model.Actividad;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NegativeOrZero;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * Created by Alejandro on 11/2/2018.
 */
public class ActividadBean {

	private Long id;

	@NotBlank(message = "{campo.obligatorio}")
    private String nombre;

	@NegativeOrZero @NotNull
	private  BigDecimal costo;

	public ActividadBean() {
		super();
	}

	public ActividadBean(Long id, String nombre, BigDecimal costo) {
		super();
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

	public void load(Actividad actividad) {
        this.setId(actividad.getId());
		this.setNombre(actividad.getNombre());
		this.setCosto(actividad.getCosto());
    }
    
}