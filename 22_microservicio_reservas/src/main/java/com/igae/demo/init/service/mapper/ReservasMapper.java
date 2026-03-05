package com.igae.demo.init.service.mapper;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.stereotype.Component;

import com.igae.demo.init.model.Reservas;
import com.igae.demo.init.service.dto.ReservasDTO;

@Component
public class ReservasMapper {

	public ReservasDTO toDto(Reservas reserva) {
		return new ReservasDTO(null,reserva.getNombre(), reserva.getDni(), null);
	}
	
	public Reservas toEntity(ReservasDTO reserva) {
		return new Reservas(null,reserva.getNombre(), reserva.getDni(), reserva.getPlazas());
	}
}
