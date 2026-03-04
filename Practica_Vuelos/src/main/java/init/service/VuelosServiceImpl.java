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
    public List<Vuelo> obtenerVuelosDisponibles(int numplazas) {
        return vuelosRepository.findVuelosDisponibles(numplazas);
    }

    @Override
    public boolean actualizarPlazas(int idvuelo, int plazasReservadas) {

        int filas = vuelosRepository.actualizarPlazas(idvuelo, plazasReservadas);

        return filas > 0;
    }
}