package com.gym.model;

import javax.persistence.*;

/**
 * Created by Alejandro on 3/3/2018.
 */

@Entity
@Table( name = "DIAS_HORARIOS_PROFESORES")
public class DiaHorarioProfesor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Dia dia;

    @ManyToOne(optional = false)
    private Horario horario;

    @ManyToOne(optional = false)
    private Profesor profesor;

    public DiaHorarioProfesor() {
        super();
    }

    public DiaHorarioProfesor(Dia dia, Horario horario, Profesor profesor) {
        this.dia = dia;
        this.horario = horario;
        this.profesor = profesor;
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

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DiaHorarioProfesor)) return false;

        DiaHorarioProfesor that = (DiaHorarioProfesor) o;

        if (dia != that.dia) return false;
        if (horario != null ? !horario.equals(that.horario) : that.horario != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (profesor != null ? !profesor.equals(that.profesor) : that.profesor != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (id != null ? id.hashCode() : 0);
        result = 31 * result + (dia != null ? dia.hashCode() : 0);
        result = 31 * result + (horario != null ? horario.hashCode() : 0);
        result = 31 * result + (profesor != null ? profesor.hashCode() : 0);
        return result;
    }
}
