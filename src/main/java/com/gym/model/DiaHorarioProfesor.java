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

    @OneToOne(optional = false)
    private Horario horario;

    @OneToOne(optional = false)
    private Profesor profesor;

    public DiaHorarioProfesor() {
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
}
