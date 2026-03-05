package com.agencia.resevas.init.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.agencia.resevas.init.model.ReservaDto;
import com.agencia.resevas.init.model.reserva;
import com.agencia.resevas.init.service.ReservaService;

@RestController
public class ReservaController {

	ReservaService reservaService;
	
	public ReservaController(ReservaService reservaService) {
		super();
		this.reservaService = reservaService;
	}

	@GetMapping("lista")
	public  List<reserva> listaReservas (){
		return reservaService.listaReservas();
	}
	
	@PostMapping("alta")
	public ResponseEntity<Void> altaReserva(@RequestBody ReservaDto reservaDto){
		System.out.println ("*********** alta");
		System.out.println (reservaDto.toString());
		if(reservaService.altaReserva(reservaDto)) {
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.status(409).build();
}
}
