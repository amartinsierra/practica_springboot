package com.igae.vuelos.init.service;

import java.util.List;

import com.igae.vuelos.init.model.Reserva;

public interface ReservaService {
	Reserva crearReserva(Reserva reserva, int totalPersonas);
	List<Reserva> listarReservas();
}
