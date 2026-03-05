package com.agencia.resevas.init.model;



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
@Table(name="reservas")

public class reserva {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idreserva;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="dni")
	private String dni;
	
	@Column(name="vuelo")
	private int vuelo;
	

}
