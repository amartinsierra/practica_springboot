package com.mjrivero25.init.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mjrivero25.init.model.Reservas;
import com.mjrivero25.init.service.ReservasService;

@RestController
public class ReservasController {

    ReservasService reservasService;

    public ReservasController(ReservasService reservasService) {
        this.reservasService = reservasService;
    }

    @PostMapping(value="reserva",consumes=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Reservas> crearReserva(Reservas reserva, int totalPersonas) {
        Reservas reservas = reservasService.crearReserva(reserva, totalPersonas);
        return ResponseEntity.ok(reservas);
    }

    @GetMapping(value="lista",produces=MediaType.APPLICATION_JSON_VALUE)
    public List<Reservas> listarReservas() {
        return reservasService.listarReservas();
    }
}
