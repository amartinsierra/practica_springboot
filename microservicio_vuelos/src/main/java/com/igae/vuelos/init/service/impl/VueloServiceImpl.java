package com.igae.vuelos.init.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.igae.vuelos.init.model.Vuelo;
import com.igae.vuelos.init.repository.VueloRepository;
import com.igae.vuelos.init.service.VueloService;

@Service
public class VueloServiceImpl implements VueloService {

    private VueloRepository vueloRepository;

    public VueloServiceImpl(VueloRepository vueloRepository) {
        this.vueloRepository = vueloRepository;
    }

    @Override
    public List<Vuelo> buscarVuelosDisponibles(int plazas) {
        return vueloRepository.findByPlazasGreaterThanEqual(plazas);
    }

    @Override
    public Vuelo actualizarPlazas(Long idVuelo, int plazasReservadas) {
        Vuelo vuelo = vueloRepository.findById(idVuelo)
                .orElseThrow(() -> new RuntimeException("Vuelo no encontrado"));

        vuelo.setPlazas(vuelo.getPlazas() - plazasReservadas);

        return vueloRepository.save(vuelo);
    }
}

