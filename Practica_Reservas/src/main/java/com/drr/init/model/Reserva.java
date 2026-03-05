package com.drr.init.model;

import jakarta.persistence.*;

@Entity
@Table(name="reservas")
public class Reserva {

    public Reserva(int idreserva, String nombre, String dni, int vuelo) {
		super();
		this.idreserva = idreserva;
		this.nombre = nombre;
		this.dni = dni;
		this.vuelo = vuelo;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idreserva;

    private String nombre;
    private String dni;

    private int vuelo;

    public Reserva() {}

    public Reserva(String nombre, String dni, int vuelo) {
        this.nombre = nombre;
        this.dni = dni;
        this.vuelo = vuelo;
    }

	public int getIdreserva() {
		return idreserva;
	}

	public void setIdreserva(int idreserva) {
		this.idreserva = idreserva;
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

	public int getVuelo() {
		return vuelo;
	}

	public void setVuelo(int vuelo) {
		this.vuelo = vuelo;
	}

}