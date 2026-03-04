package com.microserviciovuelos.init.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Vuelos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idVuelo;
	private String company;
	private String fecha;
	private Double precio;
	private int plazas;
	private String destino;
}
