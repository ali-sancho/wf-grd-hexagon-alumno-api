package com.rimac.webflux.domain.model;

/**
 * Alumno
 */
public class Alumno {

    private Long id;
    private String nombre;
    private String apellido;
    private Estado estado;
    private Integer edad;
    
    public Alumno(Long id,
                  String nombre,
                  String apellido,
                  Estado estado,
                  Integer edad) {

        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.estado = estado;
        this.edad = edad;
    }
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	public Integer getEdad() {
		return edad;
	}
	public void setEdad(Integer edad) {
		this.edad = edad;
	}
 
}
