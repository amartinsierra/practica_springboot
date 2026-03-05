package com.agencia.resevas.init.service;

import java.util.List;

import com.agencia.resevas.init.model.ReservaDto;
import com.agencia.resevas.init.model.reserva;



public interface ReservaService {

	List <reserva> listaReservas ();
	// boolean altaAlumno(Alumno alumno);
	boolean altaReserva (ReservaDto reservaDto);
}
