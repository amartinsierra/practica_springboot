package com.mjrivero25.init.repository;

import java.util.List;
import com.mjrivero25.init.model.Vuelos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface VuelosRepository extends JpaRepository<Vuelos,Integer>{

	@Query("SELECT v FROM vuelos v WHERE v.plazas > :numPlazas")
	List<Vuelos> findPlazas(int numPlazas);
	

	@Query("UPDATE vuelos v SET v.plazas = (v.plazas - :numPlazas) WHERE v.idvuelo=:idvuelo and v.plazas >= :numPlazas")
	void actualizaPlazas(int idvuelo, int numPlazas);
	
	@Query(value = "select vuelos from vuelos where idvuelo = :idvuelo")
	Vuelos getVuelo(int idvuelo);
}
