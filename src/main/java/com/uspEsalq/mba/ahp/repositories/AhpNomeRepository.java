package com.uspEsalq.mba.ahp.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uspEsalq.mba.ahp.entities.Ahp;

@Repository
public interface AhpNomeRepository extends JpaRepository<Ahp, String> {	
	List<Ahp> findByAtivo(String ativo);
}
