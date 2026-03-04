package com.csanchez.reservas.init.service;

import java.util.List;

import com.csanchez.reservas.init.models.Reserva;

public interface ReservaService {
	Reserva crearReserva(Reserva reserva, int totalPersonas);
	List<Reserva> listarReservas();
}
