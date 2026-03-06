package com.agencia.vuelos.init.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="vuelos")

public class vuelo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idVuelo;
	@Column(name="company")
	private String company;
	@Column(name="fecha")
	private String fecha;
	@Column(name="precio")
	private int precio;
	@Column(name="plazas")
	private int plazas;
	@Column(name="destino")
	private String destino;
	
}
