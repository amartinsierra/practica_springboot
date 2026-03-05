package com.agenciaviajes.reservas.service;

import com.agenciaviajes.reservas.dto.ReservaRequest;
import com.agenciaviajes.reservas.exception.VueloServiceException;
import com.agenciaviajes.reservas.model.Reserva;
import com.agenciaviajes.reservas.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${vuelos.service.url}")
    private String vuelosServiceUrl;

    @Value("${vuelos.service.username}")
    private String vuelosUsername;

    @Value("${vuelos.service.password}")
    private String vuelosPassword;

    /**
     * Crea una nueva reserva y actualiza las plazas disponibles en el servicio de vuelos.
     *
     * @param request datos de la reserva
     * @return la reserva creada
     * @throws RuntimeException si no se pueden reservar las plazas
     */
    public Reserva crearReserva(ReservaRequest request) {
        // Llamar al servicio de vuelos para actualizar plazas
        String url = vuelosServiceUrl + "/vuelo/" + request.getIdVuelo() + "/reservar/" + request.getTotalPersonas();

        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth(vuelosUsername, vuelosPassword);
        HttpEntity<Void> entity = new HttpEntity<>(headers);

        try {
            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.PUT, entity, String.class);

            if (response.getStatusCode().is2xxSuccessful()) {
                Reserva reserva = new Reserva();
                reserva.setNombreCliente(request.getNombre());
                reserva.setDni(request.getDni());
                reserva.setIdVuelo(request.getIdVuelo());
                return reservaRepository.save(reserva);
            } else {
                throw new VueloServiceException("No se pudo actualizar las plazas del vuelo", null);
            }
        } catch (Exception e) {
            throw new VueloServiceException("Error al comunicarse con el servicio de vuelos: " + e.getMessage(), e);
        }
    }

    /**
     * Obtiene todas las reservas existentes.
     *
     * @return lista de reservas
     */
    public List<Reserva> obtenerReservas() {
        return reservaRepository.findAll();
    }
}
