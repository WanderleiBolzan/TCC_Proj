package com.uspEsalq.mba.ahp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uspEsalq.mba.ahp.entities.Ativos;

@Repository
public interface SegmentoRepository extends JpaRepository<Ativos, Long> {
	List<Ativos> findAll();	
}
