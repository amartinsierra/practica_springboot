package com.agencia.vuelos.init.service;

import java.util.List;

import com.agencia.vuelos.init.model.vuelo;
import com.agencia.vuelos.init.repository.VueloRepository;

public class VueloServiceImpl implements VueloService {

	VueloRepository vueloRepository;
	
	@Override
	public List<vuelo> listaVuelos(int numPlazas) {
		return vueloRepository.listaVuelos(numPlazas);
	
	}

	@Override
	public void actualizaVuelo(int idVuelo, int numPlazas) {
		// Deberiamos comprobar 
		vueloRepository.actualizaVuelo(idVuelo, numPlazas);

	}

}
