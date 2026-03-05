package com.jcgm.init.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jcgm.init.model.Vuelo;

public interface VuelosRepository extends JpaRepository<Vuelo, Integer>{
	

}
