package com.gym.util;

import com.gym.model.Dia;

import java.io.Serializable;

/**
 * Created by Alejandro on 2/4/2018.
 */
public class LeccionDTO implements Serializable {
    private Dia newDia;
    private Long newHorario;
    private Long newProfesor;

    public Dia getNewDia() {
        return newDia;
    }

    public void setNewDia(Dia newDia) {
        this.newDia = newDia;
    }

    public Long getNewHorario() {
        return newHorario;
    }

    public void setNewHorario(Long newHorario) {
        this.newHorario = newHorario;
    }

    public Long getNewProfesor() {
        return newProfesor;
    }

    public void setNewProfesor(Long newProfesor) {
        this.newProfesor = newProfesor;
    }
}
