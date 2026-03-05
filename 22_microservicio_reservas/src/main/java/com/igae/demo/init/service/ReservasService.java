package com.igae.demo.init.service;

import java.util.List;

import com.igae.demo.init.model.Reservas;

public interface ReservasService {

	public boolean reservarVuelo(Integer vuelo, String nombre, String dni, Integer plazas);
	
	public List<Reservas> getReservas();
	
}
