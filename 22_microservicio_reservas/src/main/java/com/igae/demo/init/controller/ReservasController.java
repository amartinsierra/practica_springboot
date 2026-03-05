package com.igae.demo.init.controller;

import org.springframework.web.bind.annotation.RestController;

import com.igae.demo.init.model.Vuelos;
import com.igae.demo.init.service.ReservasService;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReservasController {

	ReservasService reservasService;
	
	public ReservasController(ReservasService reservasService) {
		this.reservasService = reservasService;
	}
	
	@PostMapping(value="reserva",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Reserva> reservarVuelos(@RequestParam Integer idVuelo, @RequestParam Integer plazas) {
		return new ResponseEntity<>(vuelosService.reservaVuelo(idVuelo, plazas),HttpStatus.OK);
	}
}
