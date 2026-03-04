package com.igae.vuelos.init.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.igae.vuelos.init.model.Reserva;
import com.igae.vuelos.init.service.ReservaService;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping(value="v1")
public class ReservaController {

    private final ReservaService reservaService;

    public ReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    @PostMapping
    public ResponseEntity<Reserva> crearReserva(@RequestBody Reserva reserva,
                                                @RequestParam int totalPersonas) {
        Reserva nueva = reservaService.crearReserva(reserva, totalPersonas);
        return ResponseEntity.ok(nueva);
    }

    @GetMapping
    public List<Reserva> listar() {
        return reservaService.listarReservas();
    }
}

