package com.igae.demo.init.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReservasDTO {

	private Integer idVuelo;
	private String nombre;
	private String dni;
	private Integer plazas;
	
}
