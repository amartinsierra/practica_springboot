package com.igae.demo.init.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.igae.demo.init.model.Reservas;
import com.igae.demo.init.service.ReservasService;
import com.igae.demo.init.service.dto.ReservasDTO;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class ReservasController {

	ReservasService reservasService;
	
	public ReservasController(ReservasService reservasService) {
		this.reservasService = reservasService;
	}
	
	@ApiResponses({
		@ApiResponse(responseCode = "201", description = "Vuelo reservado correctamente", content = @Content),
		@ApiResponse(responseCode = "409", description = "No se pudo hacer la reserva", content = @Content)
	})
	@PostMapping(value="reserva",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> reservarVuelos(@RequestBody ReservasDTO reserva) {
		if(reservasService.reservarVuelo(reserva.getIdVuelo(), reserva.getNombre(), reserva.getDni(), reserva.getPlazas())){
			return new ResponseEntity<>(HttpStatus.OK);
		}
		else 
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	
	@GetMapping(value="reservas",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Reservas>> listarReservas(){
		return new ResponseEntity<>(reservasService.getReservas(), HttpStatus.OK);
	}
	
}
