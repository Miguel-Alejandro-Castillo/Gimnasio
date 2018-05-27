package com.gym.util;

import java.math.BigDecimal;

/**
 * Created by Alejandro on 19/5/2018.
 */
public class DiaGanancia {
    private Integer dia;
    private BigDecimal total;

    public DiaGanancia(int dia, BigDecimal total) {
        super();
        this.dia = dia;
        this.total = total;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Integer getDia() {
        return dia;
    }

    public void setDia(Integer dia) {
        this.dia = dia;
    }
}
