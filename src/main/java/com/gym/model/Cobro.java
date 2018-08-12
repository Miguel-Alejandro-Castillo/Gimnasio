package com.gym.model;

import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "cobros")
public class Cobro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull(message = "{campo.obligatorio}")
	@ManyToOne
	@JoinColumn(nullable = false)
	private Actividad actividad;

	@ManyToOne
	@JoinColumn(nullable = false)
	private Profesor profesor;

	@Column(nullable = false)
	private Date momentoCobro;
	
	@NotNull(message = "{campo.obligatorio}")
	@Min(value = 1, message = "{campo.monto.mayorQue0}")
	@Column(nullable = false)
	private BigDecimal monto;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull(message = "{campo.obligatorio}")
	@Column(nullable = false)
	private Date fechaDesde;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull(message = "{campo.obligatorio}")
    @Column(nullable = false)
	private Date fechaHasta;
	
	@Column(nullable = true)
	private String comentario;
		
	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	
	public Cobro() {
		super();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Actividad getActividad() {
		return actividad;
	}

	public void setActividad(Actividad actividad) {
		this.actividad = actividad;
	}

	public Date getMomentoCobro() {
		return momentoCobro;
	}

	public void setMomentoCobro(Date momentoCobro) {
		this.momentoCobro = momentoCobro;
	}

	public BigDecimal getMonto() {
		return monto;
	}

	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}

	public Date getFechaDesde() {
		return fechaDesde;
	}

	public void setFechaDesde(Date fechaDesde) {
		this.fechaDesde = fechaDesde;
	}

	public Date getFechaHasta() {
		return fechaHasta;
	}

	public void setFechaHasta(Date fechaHasta) {
		this.fechaHasta = fechaHasta;
	}
	
	public Set<Leccion> getLecciones() {
		return this.getActividad().getLecciones();
	}
	
	public Profesor getProfesor() {
		return this.getActividad().getProfesor();
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}
}
