package com.gym.model;

import com.gym.bean.PagoBean;
import com.gym.model.Actividad;

import javax.persistence.*;

import java.math.BigDecimal;
import java.sql.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table( name = "PAGO")
public class Pago {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@OneToOne
	private Actividad actividad;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fecha_pago;
    
    @Column(nullable = false)
    private BigDecimal monto;
    
    @Column(nullable = false)
    private Time hora_pago;
    
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fecha_desde;
    
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fecha_hasta;
    
    public Pago() {
        super();
    }

    public Actividad getIdActividad() {
    	return actividad;
    }
    
    public void setIdActividad(Actividad actividad) {
    	this.actividad = actividad;
    }

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Date getFecha_pago() {
		return fecha_pago;
	}


	public void setFecha_pago(Date fecha_pago) {
		this.fecha_pago = fecha_pago;
	}


	public BigDecimal getMonto() {
		return monto;
	}

	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}

	public Time getHora_pago() {
		return hora_pago;
	}

	public void setHora_pago(Time hora_pago) {
		this.hora_pago = hora_pago;
	}

	public Date getFecha_desde() {
		return fecha_desde;
	}

	public void setFecha_desde(Date fecha_desde) {
		this.fecha_desde = fecha_desde;
	}

	public Date getFecha_hasta() {
		return fecha_hasta;
	}

	public void setFecha_hasta(Date fecha_hasta) {
		this.fecha_hasta = fecha_hasta;
	}

    public Pago(Long id, Actividad actividad, Date fecha_pago, BigDecimal monto, Time hora_pago, Date fecha_desde, Date fecha_hasta) {
		super();
		this.actividad = actividad;
		this.id = id;
		this.fecha_pago = fecha_pago;
		this.monto = monto;
		this.hora_pago = hora_pago;
		this.fecha_desde = fecha_desde;
		this.fecha_hasta = fecha_hasta;
	}
	
} 
    