package com.mjrivero25.init.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.mjrivero25.init.model.Vuelos;
import com.mjrivero25.init.repository.VuelosRepository;


@Service
public class VuelosServiceImpl implements VuelosService{
	VuelosRepository vuelosRepository;

	public VuelosServiceImpl(VuelosRepository vuelosRepository) {
		super();
		this.vuelosRepository = vuelosRepository;
	}

	@Override
	public List<Vuelos> findPlazas(int numPlazas) {
		// TODO Auto-generated method stub
		return vuelosRepository.findPlazas(numPlazas);
	}

	@Override
	public Vuelos actualizaPlazas(int idvuelo, int numPlazas) {
		// TODO Auto-generated method stub
		vuelosRepository.actualizaPlazas(idvuelo, numPlazas);
		return vuelosRepository.getVuelo(idvuelo);
	}
	

}

