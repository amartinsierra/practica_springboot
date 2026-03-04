package com.igae.init.service;

import java.util.List;

import com.igae.init.model.Vuelos;

public interface VuelosService {

    List<Vuelos> vuelosDisponibles(int plazas);
    void actualizarPlazas(int idVuelo, int plazasReservadas);
}