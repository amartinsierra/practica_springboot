package com.drr.init.dto;

public class ReservaRequest {
    public ReservaRequest(int vuelo, String nombre, String dni, int totalPersonas) {
		super();
		this.vuelo = vuelo;
		this.nombre = nombre;
		this.dni = dni;
		this.totalPersonas = totalPersonas;
	}

	private int vuelo;
    private String nombre;
    private String dni;
    private int totalPersonas;

    public ReservaRequest() {}

	public int getVuelo() {
		return vuelo;
	}

	public void setVuelo(int vuelo) {
		this.vuelo = vuelo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public int getTotalPersonas() {
		return totalPersonas;
	}

	public void setTotalPersonas(int totalPersonas) {
		this.totalPersonas = totalPersonas;
	}


}