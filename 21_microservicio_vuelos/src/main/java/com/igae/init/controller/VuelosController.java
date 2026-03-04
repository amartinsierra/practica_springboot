package com.igae.init.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.igae.init.model.Vuelos;
import com.igae.init.service.VuelosService;

@RestController
@RequestMapping("/vuelos")
public class VuelosController {

    @Autowired
    private VuelosService service;

    @GetMapping("/disponibles")
    public List<Vuelos> disponibles(@RequestParam int plazas) {
        return service.vuelosDisponibles(plazas);
    }

    @PutMapping("/{idVuelo}/{plazasReservadas}")
    @PreAuthorize("hasRole('ADMIN')")
    public void actualizarPlazas(
            @PathVariable int idVuelo,
            @PathVariable int plazasReservadas) {

        service.actualizarPlazas(idVuelo, plazasReservadas);
    }
}