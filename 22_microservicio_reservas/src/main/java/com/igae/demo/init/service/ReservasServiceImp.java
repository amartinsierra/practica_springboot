package com.igae.demo.init.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClient;

import com.igae.demo.init.model.Reservas;
import com.igae.demo.init.model.SolicitudReserva;
import com.igae.demo.init.repository.ReservasRepository;

@Service
public class ReservasServiceImp implements ReservasService {

    private final ReservasRepository reservasRepository;

	@Value("${remote.urlbase}")
	String urlBase;
	RestClient restClient;
	
	public ReservasServiceImp(RestClient restClient, ReservasRepository reservasRespository, ReservasRepository reservasRepository) {
		this.restClient = restClient;
		this.reservasRepository = reservasRepository;
	}
	
	@Override
	public boolean reservarVuelo(Integer vuelo, String nombre, String dni, Integer plazas) {
		// TODO Auto-generated method stub
		try {
			
			SolicitudReserva solicitudReserva = new SolicitudReserva(vuelo, plazas);  
			
			restClient.put()
			.uri(urlBase+"/vuelo")
			.contentType(MediaType.APPLICATION_JSON)
			.body(solicitudReserva)
			.retrieve()
			.toBodilessEntity();
			
			Reservas reserva = new Reservas();
			reserva.setDni(dni);
			reserva.setNombre(nombre);
			reserva.setVuelo(vuelo);
			reservasRepository.save(reserva);
			return true;
		}catch(HttpClientErrorException ex) {
			System.out.println(ex.getStatusCode());
			return false;
		}
		
	}

	@Override
	public List<Reservas> getReservas() {
		// TODO Auto-generated method stub
		return null;
	}

}
