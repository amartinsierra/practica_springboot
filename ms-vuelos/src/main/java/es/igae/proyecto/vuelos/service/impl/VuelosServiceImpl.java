package es.igae.proyecto.vuelos.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import es.igae.proyecto.vuelos.model.Vuelo;
import es.igae.proyecto.vuelos.repository.VuelosRepository;
import es.igae.proyecto.vuelos.service.VuelosService;

@Service
public class VuelosServiceImpl implements VuelosService{
	
	VuelosRepository vuelosRepository;
	
	public VuelosServiceImpl(VuelosRepository vuelosRepository) {
		this.vuelosRepository = vuelosRepository;
	}

	@Override
	public List<Vuelo> reservas(Integer plazas) {
		return vuelosRepository.findVuelosDisponibles(plazas);
	}

	@Override
	public void updateVuelo(Integer idVuelo, Integer plazasReservadas) {
		//vuelosRepository.updateVuelo(idVuelo, plazasReservadas);
		//System.out.println("plazasReservadas: " + plazasReservadas);
		Vuelo vuelo = vuelosRepository.findById(idVuelo).orElseThrow();
		vuelo.setPlazas(vuelo.getPlazas() - plazasReservadas);		
		vuelosRepository.save(vuelo);
		
	}

}
