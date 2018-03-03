package com.gym.model;

import javax.persistence.*;

@Entity
@Table( name = "HORARIOS")
public class Horario {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String hora_inicio;

    @Column(nullable = false)
    private String hora_fin;

    public Horario(Long id, String hora_inicio, String hora_fin) {
		
		this.id = id;
		this.hora_inicio = hora_inicio;
		this.hora_fin = hora_fin;
	}

    public Horario() {
    	super();
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
