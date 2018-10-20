package com.gym.model;

import org.hibernate.validator.constraints.NotBlank;
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
public class Actividad extends BaseEntity{

	@NotBlank(message = "{campo.obligatorio}")
	@Column(nullable = false, unique = true)
    private String nombre;

	@NotNull(message = "{campo.obligatorio}")
    @Column(nullable = false)
    private BigDecimal costo;

	@NotNull(message = "{campo.obligatorio}")
    @ManyToOne
	@JoinColumn(nullable = false)
    private Profesor profesor;
   
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Leccion> lecciones ;

    public Actividad() {
    	super();
		this.lecciones = new HashSet<Leccion>();
    }
    
    public Actividad(Long id, String nombre, BigDecimal costo, Profesor profesor) {
		this();
		this.id = id;
		this.nombre = nombre;
		this.costo = costo;
		this.profesor = profesor;
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