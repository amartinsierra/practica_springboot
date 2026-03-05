package com.drr.init.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.drr.init.client.VuelosClient;
import com.drr.init.dto.ReservaRequest;
import com.drr.init.model.Reserva;
import com.drr.init.repository.ReservasRepository;

@Service
public class ReservasService {

    private final ReservasRepository reservasRepository;
    private final VuelosClient vuelosClient;

    public ReservasService(ReservasRepository reservasRepository, VuelosClient vuelosClient) {
        this.reservasRepository = reservasRepository;
        this.vuelosClient = vuelosClient;
    }

    public Reserva crearReserva(ReservaRequest request) {
        if (request.getTotalPersonas() <= 0) {
            throw new IllegalArgumentException("totalPersonas debe ser > 0");
        }

        //Llamada a vuelos para descontar las plazas
        vuelosClient.descontarPlazas(request.getVuelo(), request.getTotalPersonas());

        //Salvar la reserva solicitada
        Reserva reserva = new Reserva(request.getNombre(), request.getDni(), request.getVuelo());
        return reservasRepository.save(reserva);
    }

    public List<Reserva> listarReservas() {
        return reservasRepository.findAll();
    }
}
