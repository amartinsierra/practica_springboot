package com.drr.init.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.drr.init.model.Vuelo;
import com.drr.init.service.VuelosService;

@RestController
@RequestMapping("/vuelos")
public class VuelosController {

    private final VuelosService vuelosService;

    public VuelosController(VuelosService vuelosService) {
        this.vuelosService = vuelosService;
    }

    /*
     * Devuelve la lista de vuelos que tengan plazas suficientes.
     */
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Vuelo>> vuelosDisponibles(@RequestParam("plazas") int plazas) {

        if (plazas <= 0) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        List<Vuelo> vuelos = vuelosService.obtenerVuelosDisponibles(plazas);
        return new ResponseEntity<>(vuelos, HttpStatus.OK);
    }

    /*
     * Actualiza las plazas del vuelo indicado (descuenta plazasReservadas).
     */
    @PutMapping(value = "/{idvuelo}/plazas/{plazasReservadas}")
    public ResponseEntity<Void> actualizarPlazas(@PathVariable int idvuelo,
                                                 @PathVariable int plazasReservadas) {

        if (plazasReservadas <= 0) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        boolean actualizado = vuelosService.actualizarPlazas(idvuelo, plazasReservadas);

        if (actualizado) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            // No existía el vuelo o no había plazas suficientes
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }
}
