package com.drr.init.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class VuelosClient {

    private final RestTemplate restTemplate;

    @Value("${vuelos.service.url}")
    private String vuelosBaseUrl;

    public VuelosClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void descontarPlazas(int idVuelo, int plazasReservadas) {
        String url = vuelosBaseUrl + "/vuelos/" + idVuelo + "/plazas/" + plazasReservadas;
        restTemplate.put(url, null);
    }
}