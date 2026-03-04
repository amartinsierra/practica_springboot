package com.csanchez.reservas.init.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

import com.csanchez.reservas.init.models.Reserva;
import com.csanchez.reservas.init.repository.ReservaRepository;
import com.csanchez.reservas.init.service.ReservaService;

@Service
public class ReservaServiceImpl implements ReservaService {
    private final ReservaRepository reservaRepository;
    private final RestTemplate restTemplate;

    @Value("${servicio.vuelos.url}")
    private String vuelosUrl;

    public ReservaServiceImpl(ReservaRepository reservaRepository, RestTemplate restTemplate) {
        this.reservaRepository = reservaRepository;
        this.restTemplate = restTemplate;
    }

    @Override
    public Reserva crearReserva(Reserva reserva, int totalPersonas) {
        String url = vuelosUrl + "/vuelos/" + reserva.getVuelo() + "/update?plazas=" + totalPersonas;
        restTemplate.put(url, null);
        return reservaRepository.save(reserva);
    }

    @Override
    public List<Reserva> listarReservas() {
        return reservaRepository.findAll();
    }
	
}
