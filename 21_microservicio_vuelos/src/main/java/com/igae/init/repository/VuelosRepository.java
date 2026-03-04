package com.igae.init.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.igae.init.model.Vuelos;

public interface VuelosRepository extends JpaRepository<Vuelos, Integer> {

    List<Vuelos> findByPlazasDisponiblesGreaterThanEqual(int plazas);
}