package com.mjrivero25.init.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mjrivero25.init.model.Reservas;
import com.mjrivero25.init.model.Vuelos;
import com.mjrivero25.init.repository.ReservasRepository;

@Service
public class ReservasServiceImpl implements ReservasService{
	ReservasRepository reservasRepository;

	public ReservasServiceImpl(ReservasRepository reservasRepository) {
		super();
		this.reservasRepository = reservasRepository;
	}

	@Override
	public List<Reservas> listarReservas() {
		// TODO Auto-generated method stub
		return reservasRepository.listarReservas();
	}

	@Override
	public Reservas crearReserva(Reservas reserva, int totalPersonas) {
		// TODO Auto-generated method stub
		return null;
	}
}
