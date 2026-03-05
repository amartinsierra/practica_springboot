package com.drr.init.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.drr.init.model.Reserva;

public interface ReservasRepository extends JpaRepository<Reserva, Integer> {
}