package com.gym.model;

import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table( name = "pagos")
public class Pago {
		
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@NotNull(message = "{campo.obligatorio}")
	@ManyToOne(optional = false)
	private Actividad actividad;

	@ManyToOne(optional = false)
	private Profesor profesor;

    @Column(nullable = false)
    private Date momentoPago;

	@NotNull(message = "{campo.obligatorio}")
	@Min(value = 0, message = "{campo.monto.min}")
    @Column(nullable = false)
    private BigDecimal montoAPagar;

	@NotNull(message = "{campo.obligatorio}")
	@Min(value = 0, message = "{campo.monto.min}")
	@Column(nullable = false)
	private BigDecimal montoRestante;

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

	public Pago() {
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

	public Date getMomentoPago() {
		return momentoPago;
	}

	public void setMomentoPago(Date momentoPago) {
		this.momentoPago = momentoPago;
	}

	public BigDecimal getMontoAPagar() {
		return montoAPagar;
	}

	public void setMontoAPagar(BigDecimal montoAPagar) {
		this.montoAPagar = montoAPagar;
	}

	public  BigDecimal getMontoRestante() {
		return montoRestante;
	}

	public void setMontoRestante(BigDecimal montoRestante) {
		this.montoRestante = montoRestante;
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

	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}
}
	 