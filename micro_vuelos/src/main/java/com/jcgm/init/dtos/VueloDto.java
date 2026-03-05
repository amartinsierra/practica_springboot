package com.jcgm.init.dtos;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VueloDto {
	private int idvuelo;
	private String company;
	private Date fecha;
	private double precio;
	private int plazas;
	private String destino;

}
