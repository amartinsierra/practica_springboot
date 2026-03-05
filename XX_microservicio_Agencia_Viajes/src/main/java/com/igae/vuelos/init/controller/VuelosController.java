package com.igae.vuelos.init.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.igae.vuelos.init.model.Vuelo;
import com.igae.vuelos.init.service.VuelosService;

import lombok.AllArgsConstructor;
@AllArgsConstructor
@RestController
public class VuelosController {

	VuelosService vuelosService;
	@GetMapping("vuelos")
	public ResponseEntity<List<Vuelo>> vuelosPorPlazas(@RequestParam int plazasAReservar){
		return ResponseEntity.ok(vuelosService.vuelosPorPlazas(plazasAReservar));
	}
	@PostMapping("vuelos")
	public ResponseEntity<Void> actualizaVuelo(@RequestParam int idVuelo,@RequestParam int plazasAReservar){
		if(vuelosService.actualizaVuelo(idVuelo, plazasAReservar)) {
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.status(409).build();
	}
}
