package init.service;

import java.util.List;

import org.springframework.stereotype.Service;

import init.model.Vuelo;
import init.repository.VuelosRepository;

@Service
public class VuelosServiceImpl implements VuelosService {

    private VuelosRepository vuelosRepository;

    public VuelosServiceImpl(VuelosRepository vuelosRepository) {
        this.vuelosRepository = vuelosRepository;
    }

    @Override
    public List<Vuelo> obtenerVuelosDisponibles(int numPlazas) {
        return vuelosRepository.findVuelosDisponibles(numPlazas);
    }

    @Override
    public boolean actualizarPlazas(int idVuelo, int plazasReservadas) {

        int filas = vuelosRepository.actualizarPlazas(idVuelo, plazasReservadas);

        return filas > 0;
    }
}