package es.igae.proyecto.vuelos.service;

import java.util.List;

import es.igae.proyecto.vuelos.model.Vuelo;

public interface VuelosService {
	List<Vuelo> reservas(Integer plazas);
	
	void updateVuelo(Integer idVuelo, Integer plazasReservadas);
}
