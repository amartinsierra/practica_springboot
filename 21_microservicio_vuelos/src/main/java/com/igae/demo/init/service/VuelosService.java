package com.igae.demo.init.service;

import java.util.List;

import com.igae.demo.init.model.Vuelos;

public interface VuelosService {

	public List<Vuelos> getVuelos(Integer plazas);
	
	public Vuelos reservaVuelo(Integer idVuelo, Integer plazas);
}
