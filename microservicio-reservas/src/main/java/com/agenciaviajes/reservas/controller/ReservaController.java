package com.agenciaviajes.reservas.controller;

import com.agenciaviajes.reservas.dto.ReservaRequest;
import com.agenciaviajes.reservas.model.Reserva;
import com.agenciaviajes.reservas.service.ReservaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Reservas", description = "API de gestión de reservas")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @Operation(
        summary = "Crear una reserva",
        description = "Registra una nueva reserva y actualiza las plazas disponibles del vuelo correspondiente"
    )
    @ApiResponses({
        @ApiResponse(responseCode = "201", description = "Reserva creada correctamente"),
        @ApiResponse(responseCode = "400", description = "Error al crear la reserva (vuelo no encontrado o plazas insuficientes)")
    })
    @PostMapping("/reserva")
    public ResponseEntity<?> crearReserva(@RequestBody ReservaRequest request) {
        try {
            Reserva reserva = reservaService.crearReserva(request);
            return ResponseEntity.status(HttpStatus.CREATED).body(reserva);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @Operation(
        summary = "Obtener todas las reservas",
        description = "Devuelve la lista de todas las reservas existentes (nombre, dni, vuelo)"
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Lista de reservas obtenida correctamente")
    })
    @GetMapping("/reservas")
    public List<Reserva> obtenerReservas() {
        return reservaService.obtenerReservas();
    }
}
