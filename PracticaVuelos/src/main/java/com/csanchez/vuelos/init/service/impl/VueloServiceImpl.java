package com.csanchez.vuelos.init.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.csanchez.vuelos.init.models.Vuelo;
import com.csanchez.vuelos.init.repository.VueloRepository;
import com.csanchez.vuelos.init.service.VueloService;

@Service
public class VueloServiceImpl implements VueloService {

	VueloRepository repository;
	
	@Override
	public List<Vuelo> getVuelos(Integer plazas) {
		// TODO Auto-generated method stub
		return repository.getVuelos(plazas);
		
	}

	@Override
	public Vuelo reservaVuelo(Integer idVuelo, Integer plazas) {
		// TODO Auto-generated method stub
		repository.updateVuelo(idVuelo, plazas);
		return repository.getVuelo(idVuelo);
	}

}
