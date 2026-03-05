package com.jcgm.init.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import com.jcgm.init.model.ActualizaPlazasParametros;
import com.jcgm.init.model.Vuelo;
import com.jcgm.init.service.VuelosService;

@RestController
@Tag(name = "Vuelos", description = "API REST para gestionar vuelos y disponibilidad de plazas")
public class VuelosController {

	private final VuelosService vuelosService;

	public VuelosController(VuelosService vuelosService) {
		this.vuelosService = vuelosService;
	}

	@GetMapping(value = "lista", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(
		summary = "Obtener lista de vuelos con plazas disponibles",
		description = "Devuelve una lista de todos los vuelos que tienen al menos el número de plazas disponibles especificado"
	)
	@ApiResponses(value = {
		@ApiResponse(
			responseCode = "200",
			description = "Lista de vuelos obtenida correctamente",
			content = @Content(
				mediaType = MediaType.APPLICATION_JSON_VALUE,
				schema = @Schema(implementation = Vuelo.class)
			)
		),
		@ApiResponse(
			responseCode = "400",
			description = "Parámetro de entrada inválido",
			content = @Content()
		)
	})
	public ResponseEntity<List<Vuelo>> listaDeVuelos(
			@Parameter(
				name = "numPlazas",
				description = "Número mínimo de plazas disponibles requeridas"
			)
			@RequestParam int numPlazas) {
		List<Vuelo> vuelos = vuelosService.getVuelos(numPlazas);
		return new ResponseEntity<>(vuelos, HttpStatus.OK);
	}


	@PutMapping(value = "actualiza", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(
		summary = "Actualizar plazas disponibles de un vuelo",
		description = "Reduce el número de plazas disponibles de un vuelo, restando las plazas especificadas del total"
	)
	@ApiResponses(value = {
		@ApiResponse(
			responseCode = "201",
			description = "Número de plazas actualizado exitosamente",
			content = @Content()
		),
		@ApiResponse(
			responseCode = "400",
			description = "Error: el número de plazas a reservar excede las plazas disponibles",
			content = @Content()
		),
		@ApiResponse(
			responseCode = "404",
			description = "Error: vuelo no encontrado",
			content = @Content()
		)
	})
	public ResponseEntity<Void> actualizaPlazas(
			@RequestBody ActualizaPlazasParametros actualizaPlazasParametros) {
		vuelosService.setVuelo(
			actualizaPlazasParametros.getIdVuelo(),
			actualizaPlazasParametros.getNumPlazas()
		);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
}