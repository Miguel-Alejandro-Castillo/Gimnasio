package com.gym.bean;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import com.gym.model.Horario;

public class HorarioBean {
	
	private Long id;
    
    @NotNull
    private String hora_inicio;
    
    @NotNull
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
        this.setHora_fin(horario.getHora_fin());
        this.setHora_inicio(horario.getHora_inicio());
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
