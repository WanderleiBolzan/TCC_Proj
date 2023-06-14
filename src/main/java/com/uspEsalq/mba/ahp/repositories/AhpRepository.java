package com.uspEsalq.mba.ahp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uspEsalq.mba.ahp.entities.Ahp;

public interface AhpRepository extends JpaRepository<Ahp, Long> {
	//Ahp getReferenceById(Long id);	
}
