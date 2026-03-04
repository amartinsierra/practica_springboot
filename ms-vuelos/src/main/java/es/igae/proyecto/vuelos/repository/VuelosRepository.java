package es.igae.proyecto.vuelos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import es.igae.proyecto.vuelos.model.Vuelo;

public interface VuelosRepository extends JpaRepository<Vuelo, Integer> {
	@Query(value="select * from vuelos where plazas >= ?", nativeQuery=true)
	List<Vuelo> findVuelosDisponibles(Integer plazas);
	
	@Query(value="update vuelos set plazas=? where idVuelo = ?", nativeQuery=true)
	void updateVuelo(Integer idVuelo, Integer plazas);

}
