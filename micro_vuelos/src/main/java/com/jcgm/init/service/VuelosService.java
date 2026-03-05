package com.jcgm.init.service;

import java.util.List;

import com.jcgm.init.model.Vuelo;

public interface VuelosService {
	List<Vuelo> getVuelos(int plazas);
	void setVuelo(int idvuelo, int plazasReservadas);
	
}
