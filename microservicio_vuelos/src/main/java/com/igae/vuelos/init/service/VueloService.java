package com.igae.vuelos.init.service;

import java.util.List;

import com.igae.vuelos.init.model.Vuelo;

public interface VueloService {
	List<Vuelo> buscarVuelosDisponibles (int plazas);
	Vuelo actualizarPlazas(Long idVuelo, int plazasReservadas);
}
