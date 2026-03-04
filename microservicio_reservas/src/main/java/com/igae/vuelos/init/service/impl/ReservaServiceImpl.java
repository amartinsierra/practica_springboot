package com.igae.vuelos.init.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClient;
import com.igae.vuelos.init.model.Reserva;
import com.igae.vuelos.init.repository.ReservaRepository;
import com.igae.vuelos.init.service.ReservaService;
@Service
public class ReservaServiceImpl implements ReservaService {
    private final ReservaRepository reservaRepository;
    RestClient restClient;

    @Value("${servicio.vuelos.url}")
    private String vuelosUrl;

    public ReservaServiceImpl(ReservaRepository reservaRepository, RestClient restClient) {
        this.reservaRepository = reservaRepository;
        this.restClient = restClient;
    }

    @Override
    public Reserva crearReserva(Reserva reserva, int totalPersonas) {

        // Llamar al microservicio de vuelos para actualizar plazas
        String url = vuelosUrl + "/vuelos/" + reserva.getVuelo() + "/actualizar?plazas=" + totalPersonas;

        restClient.put()
        		.uri(url)
        		.retrieve()
        		.toBodilessEntity();

        // Guardar la reserva en la base de datos
        return reservaRepository.save(reserva);
    }

    @Override
    public List<Reserva> listarReservas() {
        return reservaRepository.findAll();
    }
	


}
