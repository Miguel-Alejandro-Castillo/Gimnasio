package com.gym.bean;

import com.gym.model.Pago;

import org.springframework.format.annotation.DateTimeFormat;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

public class PagoBean {

	private Long id;

	@NotNull(message = "{campo.actividad.vacio}")
	private Long actividad_id;

	private Date momento_pago;

	@NotNull(message = "{campo.monto.vacio}")
    @DecimalMin(value = "0.00", message = "{campo.monto.min}")
    private BigDecimal monto;
        
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "{campo.fecha.vacio}" )
    private Date fecha_hasta;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "{campo.fecha.vacio}" )
    private Date fecha_desde;

    public PagoBean() {
        super();
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

	public  Long getActividad_id() {
		return actividad_id;
	}

	public void setActividad_id( Long actividad_id) {
		this.actividad_id = actividad_id;
	}

	public PagoBean(Long id, Long actividad_id, BigDecimal monto, Date fecha_hasta, Date fecha_desde) {
		super();
		this.id = id;
		this.actividad_id = actividad_id;
		this.momento_pago = new Date(System.currentTimeMillis());	
		this.monto = monto;
		this.fecha_hasta = fecha_hasta;
		this.fecha_desde = fecha_desde;
	}

}
