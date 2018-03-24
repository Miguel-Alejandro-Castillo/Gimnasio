package com.gym.bean;

import com.gym.model.Pago;
import com.gym.model.Actividad;
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
import java.util.Date;

public class PagoBean {

	private Actividad actividad;

	private Long id;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "{campo.fecha_de_nacimiento.vacio}" )
    @Past(message = "{campo.fecha_de_nacimiento.pasado}" )
	private Date momento_pago;
    
    @NegativeOrZero
    private BigDecimal monto;
        
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "{campo.fecha_de_nacimiento.vacio}" )
    @Past(message = "{campo.fecha_de_nacimiento.pasado}" )
    private Date fecha_hasta;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "{campo.fecha_de_nacimiento.vacio}" )
    @Past(message = "{campo.fecha_de_nacimiento.pasado}" )
    private Date fecha_desde;

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
	
	public Date getFecha_desde() {
		return fecha_desde;
	}

	public void setFecha_desde(Date fecha_desde) {
		this.fecha_desde = fecha_desde;
	}

	public PagoBean(Long id, Actividad actividad, BigDecimal monto, Date fecha_hasta, Date fecha_desde) {
		super();
		this.id = id;
		this.actividad = actividad;
		this.momento_pago = new Date(System.currentTimeMillis());	
		this.monto = monto;
		this.fecha_hasta = fecha_hasta;
		this.fecha_desde = fecha_desde;
	}

	private void load(Pago pago) {
    	this.setId(pago.getId());
    	this.setActividad(pago.getActividad());
    	this.setMomento_pago(pago.getMomento_pago());
    	this.setFecha_hasta(pago.getFecha_hasta());
    	this.setFecha_hasta(pago.getFecha_desde());
    	this.setMonto(pago.getMonto());  
    }

}
