package com.drr.init.controller;

import java.util.List;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.drr.init.dto.ReservaRequest;
import com.drr.init.model.Reserva;
import com.drr.init.service.ReservasService;

@RestController
@RequestMapping("/reservas")
public class ReservasController {

    private final ReservasService reservasService;

    public ReservasController(ReservasService reservasService) {
        this.reservasService = reservasService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Reserva> crear(@RequestBody ReservaRequest request) {
        Reserva creada = reservasService.crearReserva(request);
        return new ResponseEntity<>(creada, HttpStatus.CREATED);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Reserva>> listar() {
        return new ResponseEntity<>(reservasService.listarReservas(), HttpStatus.OK);
    }
}