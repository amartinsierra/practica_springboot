package com.csanchez.vuelos.init.service;

import java.util.List;

import com.csanchez.vuelos.init.models.Vuelo;

public interface VueloService {

	public List<Vuelo> getVuelos(Integer plazas);
	
	public Vuelo reservaVuelo(Integer idVuelo, Integer plazas);
}
