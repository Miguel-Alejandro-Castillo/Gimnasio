package com.gym.bean;

import com.gym.model.Actividad;
import com.gym.model.Pago;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NegativeOrZero;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.util.Date;
import java.math.BigDecimal;
import java.sql.*;

public class PagoBean {

	private Actividad idActividad;

	private Long id;

    private Date fecha_pago;
   
    private Time hora_pago;
    
    @NegativeOrZero
    private BigDecimal monto;
    
    @NotNull
    private Date fecha_desde;
    
    @NotNull
    private Date fecha_hasta;

    public PagoBean() {
        super();
    }
    
	public Actividad getIdActividad() {
		return idActividad;
	}

	public void setIdActividad(Actividad idActividad) {
		this.idActividad = idActividad;
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

	public Time getHora_pago() {
		return hora_pago;
	}

	public void setHora_pago(Time hora_pago) {
		this.hora_pago = hora_pago;
	}

	public BigDecimal getMonto() {
		return monto;
	}

	public void setMonto(BigDecimal monto) {
		this.monto = monto;
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
	
	public PagoBean(Actividad idActividad, Long id, Date fecha_pago, Time hora_pago, BigDecimal monto, Date fecha_desde,
			Date fecha_hasta) {
		super();
		this.idActividad = idActividad;
		this.id = id;
		this.fecha_pago = fecha_pago;
		this.hora_pago = hora_pago;
		this.monto = monto;
		this.fecha_desde = fecha_desde;
		this.fecha_hasta = fecha_hasta;
	}
    
    private void load(Pago pago) {
    	this.setId(pago.getId());
    	this.setIdActividad(pago.getIdActividad());
    	this.setFecha_desde(pago.getFecha_desde());
    	this.setFecha_pago(pago.getFecha_pago());
    	this.setFecha_hasta(pago.getFecha_hasta());
    	this.setMonto(pago.getMonto());  
    }
}
