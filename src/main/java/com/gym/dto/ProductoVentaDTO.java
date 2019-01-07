package com.gym.dto;

import java.math.BigDecimal;

public class ProductoVentaDTO {

    private Long idProducto;
    private String nombreProducto;
    private BigDecimal costoProducto;
    private Long cantVendida;
    private BigDecimal recaudado;

    public ProductoVentaDTO(){
        super();
    }

    public ProductoVentaDTO(Long idProducto, String nombreProducto, BigDecimal costoProducto, Long cantVendida, BigDecimal recaudado) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.costoProducto = costoProducto;
        this.cantVendida = cantVendida;
        this.recaudado = recaudado;
    }

    public Long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }

    public BigDecimal getCostoProducto() {
        return costoProducto;
    }

    public void setCostoProducto(BigDecimal costoProducto) {
        this.costoProducto = costoProducto;
    }

    public Long getCantVendida() {
        return cantVendida;
    }

    public void setCantVendida(Long cantVendida) {
        this.cantVendida = cantVendida;
    }

    public BigDecimal getRecaudado() {
        return recaudado;
    }

    public void setRecaudado(BigDecimal recaudado) {
        this.recaudado = recaudado;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }
}
