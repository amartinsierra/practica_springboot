package com.mjrivero25.init.service;

import java.util.List;

import com.mjrivero25.init.model.Reservas;


public interface ReservasService {
	Reservas crearReserva(Reservas reserva, int totalPersonas);
	List<Reservas> listarReservas();
}
