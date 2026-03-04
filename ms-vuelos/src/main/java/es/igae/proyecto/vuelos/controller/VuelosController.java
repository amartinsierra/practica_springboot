package es.igae.proyecto.vuelos.controller;

import es.igae.proyecto.vuelos.model.Vuelo;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import es.igae.proyecto.vuelos.service.VuelosService;

@RestController
public class VuelosController {
	VuelosService vuelosService;
	
	
	
	 public VuelosController(VuelosService vuelosService) {
		super();
		this.vuelosService = vuelosService;
	}

	 // localhost:8001/vuelos/listVuelos?plazas=2
	 @GetMapping(value="listVuelos", produces=MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity<List<Vuelo>> listarVuelos(@RequestParam Integer plazas) {
		 return new ResponseEntity<>(vuelosService.reservas(plazas), HttpStatus.OK);
	 }

	 // localhost:8001/vuelos/updateVuelo?idVuelo=1&plazasReservadas=33
	 // , consumes=MediaType.APPLICATION_JSON_VALUE
	 @PostMapping(value="updateVuelo")
	 public ResponseEntity<Void> updateVuelo(@RequestParam Integer idVuelo, @RequestParam Integer plazasReservadas) {
		 
		 vuelosService.updateVuelo(idVuelo, plazasReservadas);
		 
		 return null;
		 
	 }	
}
