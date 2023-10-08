package com.jeanlucas.cambioservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jeanlucas.cambioservice.model.Cambio;

public interface CambioRepository extends JpaRepository<Cambio, Long>{
	
	Cambio findByFromAndTo(String from, String to);
}
