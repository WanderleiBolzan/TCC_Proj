package com.uspEsalq.mba.ahp.repositories;


import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uspEsalq.mba.ahp.entities.Ativos;

@Repository
public interface AtivoNomeRepository extends JpaRepository<Ativos, String> {	
	List<Ativos> findByAtivo(String ativo);
}
