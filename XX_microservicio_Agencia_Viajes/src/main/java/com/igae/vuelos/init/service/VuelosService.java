package com.igae.vuelos.init.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;

import com.igae.vuelos.init.model.Vuelo;

public interface VuelosService {
	List<Vuelo> vuelosPorPlazas(int plazasAReservar);
	boolean actualizaVuelo(int idVuelo,@RequestParam int plazasAReservar);
	
}
