package com.csanchez.reservas.init.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.csanchez.reservas.init.models.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva,Integer>{

	
}