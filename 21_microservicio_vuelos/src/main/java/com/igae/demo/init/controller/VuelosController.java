package com.igae.demo.init.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.igae.demo.init.model.Reserva;
import com.igae.demo.init.model.Vuelos;
import com.igae.demo.init.repository.VuelosRepository;
import com.igae.demo.init.service.VuelosService;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;


@RestController
public class VuelosController {

	VuelosService vuelosService;
	VuelosRepository vuelosRepository;
	
	public VuelosController(VuelosService vuelosSerive, VuelosRepository vuelosRepository) {
		this.vuelosService = vuelosSerive;
		this.vuelosRepository = vuelosRepository;
		
	}
	
	@GetMapping(value="vuelos",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Vuelos>> vuelosDisponibles(@RequestParam Integer plazas) {
		return new ResponseEntity<>(vuelosService.getVuelos(plazas),HttpStatus.OK);
	}
	
	@ApiResponses({
		@ApiResponse(responseCode = "201", description = "Vuelo reservado correctamente", content = @Content),
		@ApiResponse(responseCode = "409", description = "No se pudo hacer la reserva", content = @Content)
	})
	@PutMapping(value="vuelo",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Vuelos> reservarVuelos(@RequestBody Reserva reserva) {
		return new ResponseEntity<>(vuelosService.reservaVuelo(reserva.getIdVuelo(), reserva.getPlazas()),HttpStatus.OK);
	}
}
	
	
	
