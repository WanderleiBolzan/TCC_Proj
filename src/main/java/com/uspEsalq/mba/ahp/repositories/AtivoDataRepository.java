package com.uspEsalq.mba.ahp.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.uspEsalq.mba.ahp.entities.Ahp;
import com.uspEsalq.mba.ahp.entities.Ativos;

@Repository
public interface AtivoDataRepository extends JpaRepository<Ahp, LocalDate> {
	List<Ativos> findByData(LocalDate data);
	@Query(value = "SELECT * FROM tb_ativos WHERE data betwen dataFin", nativeQuery = true)
	List<Ativos> findByPerData(LocalDate data1, LocalDate data2);	
	
}
