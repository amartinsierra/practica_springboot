package com.agenciaviajes.vuelos.service;

import com.agenciaviajes.vuelos.model.Vuelo;
import com.agenciaviajes.vuelos.repository.VueloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VueloService {

    @Autowired
    private VueloRepository vueloRepository;

    /**
     * Obtiene los vuelos que tienen al menos el número de plazas indicado.
     *
     * @param plazas número mínimo de plazas disponibles
     * @return lista de vuelos disponibles
     */
    public List<Vuelo> obtenerVuelosDisponibles(int plazas) {
        return vueloRepository.findByPlazasDisponiblesGreaterThanEqual(plazas);
    }

    /**
     * Actualiza las plazas disponibles de un vuelo, restando las plazas reservadas.
     *
     * @param idVuelo          identificador del vuelo
     * @param plazasReservadas número de plazas a reservar
     * @return el vuelo actualizado, o null si no existe o no hay plazas suficientes
     */
    public Vuelo actualizarPlazas(int idVuelo, int plazasReservadas) {
        Vuelo vuelo = vueloRepository.findById(idVuelo).orElse(null);
        if (vuelo != null && vuelo.getPlazasDisponibles() >= plazasReservadas) {
            vuelo.setPlazasDisponibles(vuelo.getPlazasDisponibles() - plazasReservadas);
            return vueloRepository.save(vuelo);
        }
        return null;
    }
}
