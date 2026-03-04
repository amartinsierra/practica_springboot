package com.agenciaviajes.vuelos.repository;

import com.agenciaviajes.vuelos.model.Vuelo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VueloRepository extends JpaRepository<Vuelo, Integer> {

    /**
     * Busca vuelos cuyas plazas disponibles sean mayores o iguales a las solicitadas.
     *
     * @param plazas número mínimo de plazas requeridas
     * @return lista de vuelos con suficientes plazas
     */
    List<Vuelo> findByPlazasDisponiblesGreaterThanEqual(int plazas);
}
