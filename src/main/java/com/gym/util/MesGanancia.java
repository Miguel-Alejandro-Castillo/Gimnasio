package com.gym.util;

import java.math.BigDecimal;

/**
 * Created by Alejandro on 1/5/2018.
 */
public class MesGanancia {
    private Integer mes;
    private BigDecimal total;

    public MesGanancia() {
        super();
    }

    public MesGanancia(Integer mes, BigDecimal total) {
        this();
        this.mes = mes;
        this.total = total;
    }

    public Integer getMes() {
        return mes;
    }

    public void setMes(Integer mes) {
        this.mes = mes;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}
