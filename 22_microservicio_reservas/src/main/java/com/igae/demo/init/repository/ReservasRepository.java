package com.igae.demo.init.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.igae.demo.init.model.Reservas;

public interface ReservasRepository extends JpaRepository<Reservas,Integer>{

	
}
