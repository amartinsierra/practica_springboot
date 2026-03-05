package com.igae.vuelos.init.service;

import java.util.List;

import com.igae.vuelos.init.model.Vuelo;

public interface VuelosService {
	List<Vuelo> estudiantesRango(double min, double max);
	boolean altaEstudiante(Vuelo estudiante);
}
