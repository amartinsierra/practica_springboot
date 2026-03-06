package com.agencia.vuelos.init.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.agencia.vuelos.init.model.ActualizaPlazasParametros;
import com.agencia.vuelos.init.model.vuelo;
import com.agencia.vuelos.init.service.VueloService;

@RestController
public class VueloController {

	VueloService vueloService;

	public VueloController(VueloService vueloService) {
				this.vueloService = vueloService;
	}
	
	@GetMapping (value="lista",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<vuelo>> listaDeVuelos(int numPlazas) {
		return  new ResponseEntity<>(vueloService.listaVuelos(numPlazas),HttpStatus.OK);	
	}
	
	 @PutMapping (value="actualiza",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity <Void> altaVuelo(@RequestBody ActualizaPlazasParametros actualizaPlazasParametros) {	
		 System.out.println ("+++++++++++ ");
		 System.out.println (actualizaPlazasParametros.getIdVuelo());
		 System.out.println (actualizaPlazasParametros.getNumPlazas());
		vueloService.actualizaVuelo(actualizaPlazasParametros.getIdVuelo(), actualizaPlazasParametros.getNumPlazas());
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
}
