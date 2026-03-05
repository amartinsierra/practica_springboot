package com.jcgm.init.service;

import java.util.List;

import com.jcgm.init.mappers.MapeadorVueloDto;
import com.jcgm.init.model.Vuelo;
import com.jcgm.init.repository.VuelosRepository;

public class VuelosServiceImpl implements VuelosService {
	VuelosRepository vuelosRepository;
	MapeadorVueloDto mapeadorVueloDto;
	
	public VuelosServiceImpl(VuelosRepository vuelosRepository, MapeadorVueloDto mapeadorVueloDto) {
		this.vuelosRepository = vuelosRepository;
		this.mapeadorVueloDto = mapeadorVueloDto;
	}


	public List<Vuelo> getVuelos(int numplazas) {

		return vuelosRepository.getVuelos(numplazas);
	}

	@Override
	public void setVuelo(int idvuelo, int plazasReservadas) {
		vuelosRepository.setVuelo(idvuelo, plazasReservadas);

	}
	

}
