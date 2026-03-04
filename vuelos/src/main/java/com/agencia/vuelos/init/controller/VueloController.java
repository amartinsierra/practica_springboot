package com.agencia.vuelos.init.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.agencia.vuelos.init.model.vuelo;
import com.agencia.vuelos.init.service.VueloService;

@RestController
public class VueloController {

	VueloService vueloService;

	public VueloController(VueloService vueloService) {
		super();
		this.vueloService = vueloService;
	}
	
	public ResponseEntity<List<vuelo>> listaDeVuelos(int numPlazas) {
		return  new ResponseEntity<>(vueloService.listaVuelos(numPlazas),HttpStatus.OK);	
	}
}
