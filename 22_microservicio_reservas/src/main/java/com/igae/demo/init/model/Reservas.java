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
@Table(name = "reservas")
public class Reservas {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idreserva;
	private String nombre;
	private String dni;
	private Integer vuelo;
	
}
