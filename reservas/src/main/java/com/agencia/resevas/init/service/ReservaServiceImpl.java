package com.agencia.resevas.init.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.agencia.resevas.init.model.reserva;
import com.agencia.resevas.init.repository.ReservaRepository;
@Service
public class ReservaServiceImpl implements ReservaService {
	ReservaRepository reservaRepository;
	
	public ReservaServiceImpl(ReservaRepository reservaRepository) {
		super();
		this.reservaRepository = reservaRepository;
	}

	@Override
	public List<reserva> listaReservas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean altaReserva(reserva reserva) {
		// TODO Auto-generated method stub
		reservaRepository.save(reserva);
		return true;
	}

}
