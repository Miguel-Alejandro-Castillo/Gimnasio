package com.gym.model;

import org.hibernate.validator.constraints.NotBlank;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Lenmie 04/08/18
 */

@Entity
@Table( name = "leccion")
public class Leccion {
    
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "{campo.obligatorio}")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Dia dia;

    @NotBlank(message = "{campo.obligatorio}")
    @Column(nullable = false)
    private String horaInicio;

    @NotBlank(message = "{campo.obligatorio}")
    @Column(nullable = false)
    private String horaFin;

    public Leccion() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Dia getDia() {
        return dia;
    }

    public void setDia(Dia dia) {
        this.dia = dia;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Leccion)) return false;

        Leccion leccion = (Leccion) o;

        if (dia != leccion.dia) return false;
        if (horaFin != null ? !horaFin.equals(leccion.horaFin) : leccion.horaFin != null) return false;
        if (horaInicio != null ? !horaInicio.equals(leccion.horaInicio) : leccion.horaInicio != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + (dia != null ? dia.hashCode() : 0);
        result = 31 * result + (horaInicio != null ? horaInicio.hashCode() : 0);
        result = 31 * result + (horaFin != null ? horaFin.hashCode() : 0);
        return result;
    }
}
