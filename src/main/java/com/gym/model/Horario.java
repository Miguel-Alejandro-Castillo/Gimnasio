package com.gym.model;

import javax.persistence.*;

@Entity
@Table( name = "HORARIOS")
public class Horario {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String horaInicio;

    @Column(nullable = false)
    private String horaFin;

    public Horario(Long id, String horaInicio, String horaFin) {
		
		this.id = id;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
	}

    public Horario() {
    	super();
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return this.getHoraInicio()+ " hs a "+ this.getHoraFin()+" hs";
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Horario)) return false;

		Horario horario = (Horario) o;

		if (horaFin != null ? !horaFin.equals(horario.horaFin) : horario.horaFin != null) return false;
		if (horaInicio != null ? !horaInicio.equals(horario.horaInicio) : horario.horaInicio != null) return false;
		if (id != null ? !id.equals(horario.id) : horario.id != null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (horaInicio != null ? horaInicio.hashCode() : 0);
		result = 31 * result + (horaFin != null ? horaFin.hashCode() : 0);
		return result;
	}
}
