package com.igae.vuelos.init.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Vuelo {
	private String nombre;
	private String company;
	private Date email;
	private double precio;
	private int plazas;
	private String destino;
}
