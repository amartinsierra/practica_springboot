package com.igae.init.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.igae.init.dto.ReservaDto;
import com.igae.init.model.Reservas;
import com.igae.init.service.ReservasService;

@RestController
@RequestMapping("/reservas")
public class ReservasController {

    @Autowired
    private ReservasService service;

    @PostMapping
    public void crearReserva(@RequestBody ReservaDto dto) {
        service.crearReserva(dto);
    }

    @GetMapping
    public List<Reservas> listarReservas() {
        return service.obtenerReservas();
    }
}