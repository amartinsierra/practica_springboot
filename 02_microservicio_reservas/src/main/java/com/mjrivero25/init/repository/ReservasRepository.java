package com.mjrivero25.init.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mjrivero25.init.model.Reservas;

public interface ReservasRepository extends JpaRepository<Reservas,Integer>{

	@Query(value = "SELECT reservas FROM reservas WHERE idreserva >= :idReserva")
	Reservas getReservas(int idReserva);
	
	@Query(value = "SELECT reservas FROM reservas")
	List<Reservas> listarReservas();
}
