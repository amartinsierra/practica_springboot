package com.jcgm.init.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.jcgm.init.model.Vuelo;

public interface VuelosRepository extends JpaRepository<Vuelo, Integer>{
	

	 @Query("SELECT v FROM Vuelo v WHERE v.plazas > :numPlazas")
	  List<Vuelo> getVuelos(int numPlazas);
	   @Modifying
	   @Transactional
	   @Query("UPDATE Vuelo v SET v.plazas = (v.plazas - :numPlazas) WHERE v.idvuelo=:idVuelo and  v.plazas >= :numPlazas")
	   void setVuelo (int idVuelo, int numPlazas);
	   
	   
}
