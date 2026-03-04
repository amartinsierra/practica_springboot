package com.agenciaviajes.vuelos.controller;

import com.agenciaviajes.vuelos.model.Vuelo;
import com.agenciaviajes.vuelos.service.VueloService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Vuelos", description = "API de gestión de vuelos")
public class VueloController {

    @Autowired
    private VueloService vueloService;

    @Operation(
        summary = "Obtener vuelos disponibles",
        description = "Devuelve la lista de vuelos que tienen suficientes plazas libres según el número indicado"
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Lista de vuelos disponibles obtenida correctamente")
    })
    @GetMapping("/vuelos")
    public List<Vuelo> obtenerVuelosDisponibles(
            @Parameter(description = "Número mínimo de plazas a reservar") @RequestParam int plazas) {
        return vueloService.obtenerVuelosDisponibles(plazas);
    }

    @Operation(
        summary = "Actualizar plazas de un vuelo",
        description = "Reserva plazas en un vuelo, restando las plazas indicadas de las disponibles. Requiere rol ADMIN."
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Plazas actualizadas correctamente"),
        @ApiResponse(responseCode = "404", description = "Vuelo no encontrado o plazas insuficientes"),
        @ApiResponse(responseCode = "401", description = "No autenticado"),
        @ApiResponse(responseCode = "403", description = "No autorizado (requiere rol ADMIN)")
    })
    @PutMapping("/vuelo/{idVuelo}/reservar/{plazas}")
    public ResponseEntity<Vuelo> actualizarPlazas(
            @Parameter(description = "Identificador del vuelo") @PathVariable int idVuelo,
            @Parameter(description = "Número de plazas a reservar") @PathVariable int plazas) {
        Vuelo vuelo = vueloService.actualizarPlazas(idVuelo, plazas);
        if (vuelo != null) {
            return ResponseEntity.ok(vuelo);
        }
        return ResponseEntity.notFound().build();
    }
}
