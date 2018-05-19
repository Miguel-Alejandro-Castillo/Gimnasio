package com.gym.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table( name = "pagos")
public class Pago {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@ManyToOne(optional = false)
	private Actividad actividad;

    @Column(nullable = false)
    private Date momento_pago;
    
    @Column(nullable = false)
    private BigDecimal monto;

	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date fecha_desde;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fecha_hasta;
    

    
	public Pago() {
        super();
    }

    public Pago(Long id, Actividad actividad, BigDecimal monto, Date fecha_hasta, Date fecha_desde) {
		super();
		this.id = id;
		this.actividad = actividad;
		this.momento_pago = new Date(System.currentTimeMillis());
		this.monto = monto;
		this.fecha_hasta = fecha_hasta;
		this.fecha_desde = fecha_desde;
	}
    
    public Date getFecha_desde() {
		return fecha_desde;
	}

	public void setFecha_desde(Date fecha_desde) {
		this.fecha_desde = fecha_desde;
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

	public Date getFecha_hasta() {
		return fecha_hasta;
	}

	public void setFecha_hasta(Date fecha_hasta) {
		this.fecha_hasta = fecha_hasta;
	}
	
}
	 