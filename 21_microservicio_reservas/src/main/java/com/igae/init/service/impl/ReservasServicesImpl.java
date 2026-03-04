package com.igae.init.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.igae.init.dto.ReservaDto;
import com.igae.init.model.Reservas;
import com.igae.init.repository.ReservasRepository;
import com.igae.init.service.ReservasService;

@Service
public class ReservasServicesImpl implements ReservasService {

    @Autowired
    private ReservasRepository repository;

    @Autowired
    private RestTemplate rest;

    private final String URL_VUELOS = "http://vuelos-service/vuelos";

    @Override
    public void crearReserva(ReservaDto dto) {

        // 1. Actualizar plazas en servicio vuelos
        rest.put(URL_VUELOS + "/" + dto.getIdVuelo()
                + "/" + dto.getPersonas(), null);

        // 2. Guardar la reserva
        Reservas r = new Reservas(
                null,
                dto.getNombre(),
                dto.getDni(),
                dto.getIdVuelo()
        );

        repository.save(r);
    }

    @Override
    public List<Reservas> obtenerReservas() {
        return repository.findAll();
    }
}
