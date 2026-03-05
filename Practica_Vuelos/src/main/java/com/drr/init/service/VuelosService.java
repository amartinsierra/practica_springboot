package com.drr.init.service;

import java.util.List;

import com.drr.init.model.Vuelo;

public interface VuelosService {
    List<Vuelo> obtenerVuelosDisponibles(int numplazas);

    /*
     * @return true si se han descontado plazas; false si no hay plazas suficientes o no existe el vuelo
     */
    boolean actualizarPlazas(int idvuelo, int plazasReservadas);
}