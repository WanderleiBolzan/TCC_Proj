package com.uspEsalq.mba.ahp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uspEsalq.mba.ahp.entities.Ativos;

public interface AtivoRepository extends JpaRepository<Ativos, Long> {
	Ativos getReferenceById(Long id);	
}
