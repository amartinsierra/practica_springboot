package com.agencia.vuelos.init.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.agencia.vuelos.init.model.vuelo;
import com.agencia.vuelos.init.repository.VueloRepository;


@Service
public class VueloServiceImpl implements VueloService {

	VueloRepository vueloRepository;
	
	public VueloServiceImpl(VueloRepository vueloRepository) {
		super();
		this.vueloRepository = vueloRepository;
	}

	
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
