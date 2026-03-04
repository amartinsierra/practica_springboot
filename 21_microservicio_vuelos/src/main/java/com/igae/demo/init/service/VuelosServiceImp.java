package com.igae.demo.init.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.igae.demo.init.model.Vuelos;
import com.igae.demo.init.repository.VuelosRepository;

@Service
public class VuelosServiceImp implements VuelosService {

	VuelosRepository vuelos;
	
	@Override
	public List<Vuelos> getVuelos(Integer plazas) {
		// TODO Auto-generated method stub
		return vuelos.getVuelos(plazas);
		
	}

	@Override
	public Vuelos reservaVuelo(Integer idVuelo, Integer plazas) {
		// TODO Auto-generated method stub
		vuelos.updateVuelo(idVuelo, plazas);
		return vuelos.getVuelo(idVuelo);
	}

}
