package com.igae.demo.init.model;

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
public class Vuelos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idvuelo;
	private String company;
	private String fecha;
	private Double precio;
	private Integer plazas;
	private String destino;
}
