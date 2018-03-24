package com.gym.model;

import com.gym.bean.PagoBean;
import com.gym.model.Actividad;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Calendar;

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
    private Calendar momento_pago;
    
    @Column(nullable = false)
    private BigDecimal monto;
       
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Calendar fecha_hasta;
    
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Calendar fecha_desde;
    
	public Pago() {
        super();
    }

    public Pago(Long id, Actividad actividad, BigDecimal monto, Calendar fecha_hasta, Calendar fecha_desde) {
		super();
		this.id = id;
		this.actividad = actividad;
		this.momento_pago = Calendar.getInstance();
		this.monto = monto;
		this.fecha_hasta = fecha_hasta;
		this.fecha_desde = fecha_desde;
	}
    
    public Calendar getFecha_desde() {
		return fecha_desde;
	}

	public void setFecha_desde(Calendar fecha_desde) {
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
	
}
	 