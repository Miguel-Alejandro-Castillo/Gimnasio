package com.gym.bean;

//import com.gym.model.Servicio;

/**
 * Created by Alejandro on 11/2/2018.
 */
public class ServicioBean {

	private Long id;
    private String nombreServicio;
    private String profesor;
    private Integer costo;
    private String dia;
    private String rangoHorario;	
	
    public ServicioBean(Long id, String nombreServicio, String profesor, Integer costo, String dia,
			String rangoHorario) {
		super();
		this.id = id;
		this.nombreServicio = nombreServicio;
		this.profesor = profesor;
		this.costo = costo;
		this.dia = dia;
		this.rangoHorario = rangoHorario;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombreServicio() {
		return nombreServicio;
	}
	public void setNombreServicio(String nombreServicio) {
		this.nombreServicio = nombreServicio;
	}
	public String getProfesor() {
		return profesor;
	}
	public void setProfesor(String profesor) {
		this.profesor = profesor;
	}
	public Integer getCosto() {
		return costo;
	}
	public void setCosto(Integer costo) {
		this.costo = costo;
	}
	public String getDia() {
		return dia;
	}
	public void setDia(String dia) {
		this.dia = dia;
	}
	public String getRangoHorario() {
		return rangoHorario;
	}
	public void setRangoHorario(String rangoHorario) {
		this.rangoHorario = rangoHorario;
	}
    
    
    
}