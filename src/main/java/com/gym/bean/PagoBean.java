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
import java.math.BigDecimal;
import java.util.Calendar;

public class PagoBean {

	private Actividad actividad;

	private Long id;
	
	private Calendar momento_pago;
    
    @NegativeOrZero
    private BigDecimal monto;
        
    @NotNull
    private Calendar fecha_hasta;

    public PagoBean() {
        super();
    }
    
    public Actividad getActividad() {
		return actividad;
	}

	public void setActividad(Actividad actividad) {
		this.actividad = actividad;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Calendar getMomento_pago() {
		return momento_pago;
	}

	public void setMomento_pago(Calendar momento_pago) {
		this.momento_pago = momento_pago;
	}

	public BigDecimal getMonto() {
		return monto;
	}

	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}

	public Calendar getFecha_hasta() {
		return fecha_hasta;
	}

	public void setFecha_hasta(Calendar fecha_hasta) {
		this.fecha_hasta = fecha_hasta;
	}

	public PagoBean(Long id, Actividad actividad, BigDecimal monto, Calendar fecha_hasta) {
		super();
		this.id = id;
		this.actividad = actividad;
		this.momento_pago = Calendar.getInstance();
		this.monto = monto;
		this.fecha_hasta = fecha_hasta;
	}

	private void load(Pago pago) {
    	this.setId(pago.getId());
    	this.setActividad(pago.getActividad());
    	this.setMomento_pago(pago.getMomento_pago());
    	this.setFecha_hasta(pago.getFecha_hasta());
    	this.setMonto(pago.getMonto());  
    }
}
