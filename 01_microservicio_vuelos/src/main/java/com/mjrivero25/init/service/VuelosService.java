package com.mjrivero25.init.service;

import java.util.List;

import com.mjrivero25.init.model.Vuelos;

public interface VuelosService {
	List<Vuelos> findPlazas(int numPlazas);
	Vuelos actualizaPlazas(int idvuelo, int numPlazas);
}
