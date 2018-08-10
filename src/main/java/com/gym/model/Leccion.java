package com.gym.model;

import javax.persistence.*;

/**
 * Created by Lenmie 04/08/18
 */

@Entity
@Table( name = "leccion")
public class Leccion {
    
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Dia dia;

    @ManyToOne(optional = false)
    private Horario horario;

    public Leccion() {
        super();
    }

    public Leccion(Dia dia, Horario horario) {
        this.dia = dia;
        this.horario = horario;
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

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }
    
    
    public String getHoraInicio() {
		return this.getHorario().getHoraInicio();
	}

	public void setHoraInicio(String horaInicio) {
		this.getHorario().setHoraInicio(horaInicio);
	}

	public String getHoraFin() {
		return this.getHorario().getHoraFin();
	}

	public void setHoraFin(String horaFin) {
		this.getHorario().setHoraFin(horaFin);
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Leccion)) return false;

        Leccion that = (Leccion) o;

        if (dia != that.dia) return false;
        if (horario != null ? !horario.equals(that.horario) : that.horario != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (id != null ? id.hashCode() : 0);
        result = 31 * result + (dia != null ? dia.hashCode() : 0);
        result = 31 * result + (horario != null ? horario.hashCode() : 0);
        return result;
    }
}
