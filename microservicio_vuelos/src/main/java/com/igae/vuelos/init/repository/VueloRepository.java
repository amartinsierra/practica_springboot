package com.igae.vuelos.init.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.igae.vuelos.init.model.Vuelo;

public interface VueloRepository extends JpaRepository<Vuelo, Long> {
	//Consulta para ver vuelos disponibles
	List<Vuelo> findByPlazasGreaterThanEqual(int plazas);
}
