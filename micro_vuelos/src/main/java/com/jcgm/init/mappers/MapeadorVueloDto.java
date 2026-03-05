package com.jcgm.init.mappers;

import org.springframework.stereotype.Component;

import com.jcgm.init.dtos.VueloDto;
import com.jcgm.init.model.Vuelo;

@Component
public class MapeadorVueloDto {
	
	public VueloDto vueloToDto(Vuelo vuelo) {
		VueloDto dto = new VueloDto();
		dto.setIdvuelo(vuelo.getIdvuelo());
		dto.setDestino(vuelo.getDestino());
		dto.setCompany(vuelo.getCompany());
		dto.setFecha(vuelo.getFecha());
		dto.setPlazas(vuelo.getPlazas());
		dto.setPlazas(vuelo.getPlazas());
		return dto;
	}
}
