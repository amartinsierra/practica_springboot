package com.agencia.resevas.init.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.agencia.resevas.init.model.reserva;



public interface ReservaRepository extends JpaRepository<reserva,Integer>{

	
	  // @Query("SELECT r FROM reserva r" )
	  List<reserva> findAll();
	  
	  
}
