package com.agencia.resevas.init.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReservaDto {
	private int vuelo;
	private String nombre;
	private String dni;
	private int numPlazas;
}
