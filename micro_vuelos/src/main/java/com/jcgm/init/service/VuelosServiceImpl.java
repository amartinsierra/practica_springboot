package com.jcgm.init.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.jcgm.init.model.Vuelo;
import com.jcgm.init.repository.VuelosRepository;

@Service
public class VuelosServiceImpl implements VuelosService {
	VuelosRepository vuelosRepository;
	
	public VuelosServiceImpl(VuelosRepository vuelosRepository) {
		this.vuelosRepository = vuelosRepository;
	}


	public List<Vuelo> getVuelos(int numplazas) {

		return vuelosRepository.getVuelos(numplazas);
	}

	@Override
	public void setVuelo(int idvuelo, int plazasReservadas) {
		vuelosRepository.setVuelo(idvuelo, plazasReservadas);

	}
	

}
