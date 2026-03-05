package com.igae.demo.init.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.igae.demo.init.model.Vuelos;
import com.igae.demo.init.repository.VuelosRepository;

@Service
public class VuelosServiceImp implements VuelosService {

	VuelosRepository vuelos;
	
	public VuelosServiceImp(VuelosRepository vuelos) {
		this.vuelos = vuelos;
	}
	
	@Override
	public List<Vuelos> getVuelos(Integer plazas) {
		// TODO Auto-generated method stub
		if(plazas == null) plazas = 10;
		return vuelos.getVuelos(plazas);
		
	}

	@Override
	public Vuelos reservaVuelo(Integer idVuelo, Integer plazas) {
		// TODO Auto-generated method stub
		vuelos.updateVuelo(idVuelo, plazas);
		return vuelos.getVuelo(idVuelo);
	}

}
