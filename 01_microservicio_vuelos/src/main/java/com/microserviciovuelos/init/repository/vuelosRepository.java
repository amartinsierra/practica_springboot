package com.microserviciovuelos.init.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.microserviciovuelos.init.model.Vuelos;

public interface vuelosRepository extends JpaRepository<Vuelos, Integer> {

	@Transactional(readOnly = true)
	@Query(value = "SELECT vuelos FROM vuelos WHERE PLAZAS >= :plazas", nativeQuery = true)
	List<Vuelos> getVuelos(@Param("plazas") Integer plazas);
	@Transactional(readOnly = true)
	@Query(value = "SELECT vuelos FROM vuelos WHERE idVuelo = :idVuelo", nativeQuery = true)
	Vuelos getVuelo(@Param("idVuelo") Integer idVuelo);
	@Transactional
    @Modifying
    @Query(value = "UPDATE vuelos SET PLAZAS = (PLAZAS - :plazas) WHERE idVuelo= :idVuelo", nativeQuery = true)
    void updateVuelo(@Param("idVuelo") Integer idVuelo, @Param("plazas") Integer plazas);
}
