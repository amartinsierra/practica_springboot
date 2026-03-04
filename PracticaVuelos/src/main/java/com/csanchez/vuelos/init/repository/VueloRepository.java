package com.csanchez.vuelos.init.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.csanchez.vuelos.init.models.Vuelo;


public interface VueloRepository extends JpaRepository<Vuelo,Integer>{

	
	@Transactional(readOnly = true)
	@Query(value = "select vuelos from vuelos where plazas >= :plazas", nativeQuery = true)
	List<Vuelo> getVuelos(@Param("plazas") Integer plazas);
	
	@Transactional
    @Modifying
    @Query(value = "update vuelos set plazas = (plazas - :plazas) where idVuelo= :idVuelo", nativeQuery = true)
    void updateVuelo(@Param("idVuelo") Integer idVuelo, @Param("plazas") Integer plazas);
	
}
