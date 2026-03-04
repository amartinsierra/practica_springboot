package com.agencia.vuelos.init.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.agencia.vuelos.init.model.vuelo;

public interface VueloRepository extends JpaRepository<vuelo,Integer>{

  @Query("SELECT v FROM vuelo v WHERE v.plazas > :numPlazas")
  List<vuelo> listaVuelos(int numPlazas);
	
  @Query("UPDATE vuelo v SET v.plazas = :numPlazas WHERE v.idVuelo=:idVuelo and  v.plazas >= :numPlazas")
  void actualizaVuelo (int idVuelo, int numPlazas);
	
}
