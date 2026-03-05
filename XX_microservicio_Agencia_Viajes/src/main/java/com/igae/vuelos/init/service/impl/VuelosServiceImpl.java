package com.igae.vuelos.init.service.impl;

import java.util.Arrays;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClient;

import com.igae.vuelos.init.model.CredentialsDto;
import com.igae.vuelos.init.model.Vuelo;
import com.igae.vuelos.init.service.VuelosService;

import lombok.AllArgsConstructor;
@Service
public class VuelosServiceImpl implements VuelosService,InitializingBean{
	@Value("${remote.urlbase}")
	String urlBase;
	@Value("${remote.user}")
	String user;
	@Value("${remote.password}")
	String pass;
	
	String token;
	
	RestClient restClient;
	
	public VuelosServiceImpl(RestClient restClient) {
		this.restClient = restClient;
	}

	
	@Override
	public void afterPropertiesSet() throws Exception {
		generarToken();
		
	}
	
	private void generarToken() {
		//obtenemos el token
		token= restClient.post()
					.uri(urlBase+"/login")
					.contentType(MediaType.APPLICATION_JSON)
					.body(new CredentialsDto(user,pass))
					.retrieve()
					.body(String.class);
	}

	@Override
	public List<Vuelo> vuelosPorPlazas(int plazasAReservar) {
		return Arrays.stream(restClient.get()
				.uri(urlBase+"/vuelos")
				.header("Authorization", "Bearer "+token)
				.retrieve()
				.body(Vuelo[].class)
				).filter(e->e.getPlazas()>=plazasAReservar)
				.toList();
	}

	@Override
	public boolean actualizaVuelo(int idVuelo, int plazasAReservar) {
		try {
			restClient.get()
			.uri(urlBase+"/vuelos")
			.header("Authorization", "Bearer "+token)
			.retrieve();
			return true;
		}catch(HttpClientErrorException ex) {
			System.out.println(ex.getStatusCode());
			return false;
		}
	}

}
