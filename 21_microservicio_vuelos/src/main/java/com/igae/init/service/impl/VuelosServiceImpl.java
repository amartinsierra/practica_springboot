package com.igae.init.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.igae.init.model.Vuelos;
import com.igae.init.repository.VuelosRepository;
import com.igae.init.service.VuelosService;

@Service
public class VuelosServiceImpl implements VuelosService {

    @Autowired
    private VuelosRepository repo;

    @Override
    public List<Vuelos> vuelosDisponibles(int plazas) {
        return repo.findByPlazasDisponiblesGreaterThanEqual(plazas);
    }

    @Override
    public void actualizarPlazas(int idVuelo, int plazasReservadas) {
        Vuelos vuelo = repo.findById(idVuelo).orElseThrow();
        vuelo.setPlazasDisponibles(vuelo.getPlazasDisponibles() - plazasReservadas);
        repo.save(vuelo);
    }
}