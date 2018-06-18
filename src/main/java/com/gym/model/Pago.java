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

    @Column(nullable = false)
    private Date momento_pago;

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

	public Date getMomento_pago() {
		return momento_pago;
	}

	public void setMomento_pago(Date momento_pago) {
		this.momento_pago = momento_pago;
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
}
	 