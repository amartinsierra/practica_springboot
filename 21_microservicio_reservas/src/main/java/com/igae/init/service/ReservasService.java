package com.igae.init.service;

import java.util.List;

import com.igae.init.dto.ReservaDto;
import com.igae.init.model.Reservas;

public interface ReservasService {

    void crearReserva(ReservaDto dto);
    List<Reservas> obtenerReservas();
}
