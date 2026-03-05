package com.mjrivero25.init.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mjrivero25.init.model.Vuelos;
import com.mjrivero25.init.service.VuelosService;

@RestController
public class VuelosController {

	VuelosService vuelosService;
	
	public VuelosController(VuelosService vuelosService) {
		this.vuelosService = vuelosService;
	}
	
	@GetMapping(value="vuelos/plaza",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Vuelos>> vuelosPlazaLibre(@RequestParam int numPlazas) {
		return new ResponseEntity<>(vuelosService.findPlazas(numPlazas),HttpStatus.OK);
	}
	
	@PutMapping(value="vuelo",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Vuelos> reservarVuelos(@RequestParam int idvuelo, @RequestParam int numPlazas) {
		return new ResponseEntity<>(vuelosService.actualizaPlazas(idvuelo, numPlazas),HttpStatus.OK);
	}
	
}




