package com.jcgm.init.model;

import java.util.Date;

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
@Table(name = "vuelos")
public class Vuelo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idvuelo;
	@Column(name = "company")
	private String company;
	@Column(name = "fecha")
	private Date fecha;
	@Column(name = "precio")
	private double precio;
	@Column(name = "plazas")
	private int plazas;
	@Column(name = "destino")
	private String destino;
}
