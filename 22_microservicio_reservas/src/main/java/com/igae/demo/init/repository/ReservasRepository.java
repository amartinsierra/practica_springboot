package com.igae.demo.init.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.igae.demo.init.model.Reservas;

public interface ReservasRepository extends JpaRepository<Reservas,Integer>{

	@Transactional(readOnly = true)
	@Query(value = "SELECT RESERVAS FROM RESERVAS WHERE IDRESERVAS >= :idReserva")
	Reservas getReservas(@Param("plazas") Integer idReserva);
	
}
