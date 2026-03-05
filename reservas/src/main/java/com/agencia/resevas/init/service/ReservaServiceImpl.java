package com.agencia.resevas.init.service;

import java.util.List;


import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClient;
import org.springframework.http.MediaType;
import com.agencia.resevas.init.model.ActualizaPlazasParametros;
import com.agencia.resevas.init.model.ReservaDto;
import com.agencia.resevas.init.model.reserva;
import com.agencia.resevas.init.repository.ReservaRepository;
@Service
public class ReservaServiceImpl implements ReservaService {
	
	String urlBase ="http://localhost:8001/vuelos";
	
	RestClient restClient;
	ReservaRepository reservaRepository;
	
	
	public ReservaServiceImpl(RestClient restClient, ReservaRepository reservaRepository) {	
		this.restClient = restClient;
		this.reservaRepository = reservaRepository;
	}

	@Override
	public List<reserva> listaReservas() {
		return reservaRepository.findAll();
	}

	@Override
	public boolean altaReserva (ReservaDto reservaDto) {
	


		try {
			System.out.println ("****1");
			// Decrementar el numero de plazas de este vuelo
			restClient.put()
			.uri(urlBase+"/actualiza" )
			.contentType(MediaType.APPLICATION_JSON)
			.body(new ActualizaPlazasParametros(reservaDto.getVuelo(),reservaDto.getNumPlazas()))
			.retrieve()
			.toBodilessEntity();
			System.out.println ("****2");
			// Hacemos la reserva
			reservaRepository.save(new reserva(0, reservaDto.getNombre(),reservaDto.getDni(), reservaDto.getVuelo()));
			System.out.println ("****3");
			return true;
		}
		catch (HttpClientErrorException ex) 
		{		
			return false;
		}

}
}
