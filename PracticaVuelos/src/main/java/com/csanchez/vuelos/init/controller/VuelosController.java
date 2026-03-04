package com.csanchez.vuelos.init.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.csanchez.vuelos.init.models.Vuelo;
import com.csanchez.vuelos.init.service.VueloService;


@RestController
public class VuelosController {

	VueloService vuelosService;
	
	public VuelosController(VueloService vuelosSerive) {
		this.vuelosService = vuelosSerive;
	}
	
	@GetMapping(value="vuelos",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Vuelo>> vuelosDisponibles(@RequestParam Integer plazas) {
		return new ResponseEntity<>(vuelosService.getVuelos(plazas),HttpStatus.OK);
	}
	
	@PutMapping(value="vuelo",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Vuelo> reservarVuelos(@RequestParam Integer idVuelo, @RequestParam Integer plazas) {
		return new ResponseEntity<>(vuelosService.reservaVuelo(idVuelo, plazas),HttpStatus.OK);
	}
	
}
