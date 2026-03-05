package com.jcgm.init.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VueloDto {
	private int idvuelo;
	private String company;
	private String fecha;
	private double precio;
	private int plazas;
	private String destino;

}
