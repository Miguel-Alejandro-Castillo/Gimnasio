package com.gym.model;

import javax.persistence.*;

@Entity
@Table( name = "horarios")
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

	@Override
	public String toString() {
		return this.getHora_inicio()+ " hs a "+ this.getHora_fin()+" hs";
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Horario)) return false;

		Horario horario = (Horario) o;

		if (hora_fin != null ? !hora_fin.equals(horario.hora_fin) : horario.hora_fin != null) return false;
		if (hora_inicio != null ? !hora_inicio.equals(horario.hora_inicio) : horario.hora_inicio != null) return false;
		if (id != null ? !id.equals(horario.id) : horario.id != null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = (id != null ? id.hashCode() : 0);
		result = 31 * result + (hora_inicio != null ? hora_inicio.hashCode(): 0);
		result = 31 * result + (hora_fin != null ? hora_fin.hashCode() : 0);
		return result;
	}
}
