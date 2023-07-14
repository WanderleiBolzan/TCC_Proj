package com.uspEsalq.mba.ahp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uspEsalq.mba.ahp.entities.Empresas;

@Repository
public interface EmpresasRepository extends JpaRepository<Empresas, Long>{

}
