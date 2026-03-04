package com.igae.vuelos.init.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.igae.vuelos.init.model.Vuelo;
import com.igae.vuelos.init.service.VueloService;

@RestController
@RequestMapping("/v1")
public class VueloController {

    private final VueloService vueloService;

    public VueloController(VueloService vueloService) {
        this.vueloService = vueloService;
    }

    @GetMapping
    public List<Vuelo> buscarVuelos(@RequestParam int plazas) {
        return vueloService.buscarVuelosDisponibles(plazas);
    }

    @PutMapping("/{idVuelo}/actualizar")
    public Vuelo actualizarPlazas(@PathVariable Long idVuelo,
                                  @RequestParam int plazas) {
        return vueloService.actualizarPlazas(idVuelo, plazas);
    }
}

