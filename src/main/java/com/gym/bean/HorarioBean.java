package com.gym.bean;

import com.gym.model.Horario;

public class HorarioBean {
	
	private Long id;

    private String hora_inicio;

    private String hora_fin;

    public HorarioBean() {
        super();
    }

    public HorarioBean(Long id, String hora_inicio, String hora_fin) {
		super();
		this.id = id;
		this.hora_inicio = hora_inicio;
		this.hora_fin = hora_fin;
	}
    
    public void load(Horario horario) {
        this.setId(horario.getId());
        this.setHora_fin(horario.getHoraFin());
        this.setHora_inicio(horario.getHoraInicio());
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getHora_inicio() {
		return hora_inicio;
	}

	public void setHora_inicio(String hora_inicio) {
		this.hora_inicio = hora_inicio;
	}

	public String getHora_fin() {
		return hora_fin;
	}

	public void setHora_fin(String hora_fin) {
		this.hora_fin = hora_fin;
	}
}
