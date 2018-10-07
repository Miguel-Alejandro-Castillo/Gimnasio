package com.gym.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Alejandro on 9/9/2018.
 */
public class PagoClienteDTO {
    private String cliente;
    private String actividad;
    private Date momentoPago;
    private BigDecimal montoAPagar;
    private BigDecimal montoPagado;
    private Date fechaDesde;
    private Date fechaHasta;

    public PagoClienteDTO(String cliente, String actividad, Date momentoPago, BigDecimal montoAPagar, BigDecimal montoPagado, Date fechaDesde, Date fechaHasta) {
        this.cliente = cliente;
        this.actividad = actividad;
        this.momentoPago = momentoPago;
        this.montoAPagar = montoAPagar;
        this.montoPagado = montoPagado;
        this.fechaDesde = fechaDesde;
        this.fechaHasta = fechaHasta;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
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

    public BigDecimal getMontoPagado() {
        return montoPagado;
    }

    public void setMontoPagado(BigDecimal montoPagado) {
        this.montoPagado = montoPagado;
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
