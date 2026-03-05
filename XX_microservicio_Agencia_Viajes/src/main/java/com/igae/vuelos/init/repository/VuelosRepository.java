package com.igae.vuelos.init.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.igae.vuelos.init.model.Vuelo;

public interface VuelosRepository extends JpaRepository<Vuelo,Integer>{ 
	
}
