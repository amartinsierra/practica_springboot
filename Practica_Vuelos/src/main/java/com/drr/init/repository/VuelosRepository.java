package com.drr.init.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.drr.init.model.Vuelo;

public interface VuelosRepository extends JpaRepository<Vuelo,Integer>{	
		
	@Query("SELECT v FROM Vuelo v WHERE v.plazas >= :numplazas")
	List<Vuelo> findVuelosDisponibles(@Param("numplazas") int numplazas);
	
	
	@Modifying
	@Transactional
	@Query("UPDATE Vuelo v SET v.plazas = v.plazas - :numplazas WHERE v.idvuelo = :idvuelo AND v.plazas >= :numplazas")
	int actualizarPlazas(@Param("idvuelo") int idvuelo, @Param("numplazas") int numplazas);
	
	
}
