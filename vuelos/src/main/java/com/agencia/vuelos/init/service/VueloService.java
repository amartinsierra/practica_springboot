package com.agencia.vuelos.init.service;

import java.util.List;

import com.agencia.vuelos.init.model.vuelo;


public interface VueloService {
	List<vuelo> listaVuelos(int numPlazas);
	void actualizaVuelo (int idVuelo, int numPlazas);
}
