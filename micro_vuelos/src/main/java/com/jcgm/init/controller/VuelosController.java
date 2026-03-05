package com.jcgm.init.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jcgm.init.model.ActualizaPlazasParametros;
import com.jcgm.init.model.Vuelo;
import com.jcgm.init.service.VuelosService;

@RestController
public class VuelosController {

	VuelosService vuelosService;

	public VuelosController(VuelosService vuelosService) {
				this.vuelosService = vuelosService;
	}
	
	@GetMapping (value="lista",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Vuelo>> listaDeVuelos(int numPlazas) {
		return  new ResponseEntity<>(vuelosService.getVuelos(numPlazas),HttpStatus.OK);	
	}
	
	@PutMapping (value="actualiza",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity <Void> altaVuelo(@RequestBody ActualizaPlazasParametros actualizaPlazasParametros) {	
		 System.out.println ("+++++++++++ ");
		 System.out.println (actualizaPlazasParametros.getIdVuelo());
		 System.out.println (actualizaPlazasParametros.getNumPlazas());
		vuelosService.setVuelo(actualizaPlazasParametros.getIdVuelo(), actualizaPlazasParametros.getNumPlazas());
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
}
