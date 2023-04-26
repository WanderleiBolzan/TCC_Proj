package com.uspEsalq.mba.ahp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uspEsalq.mba.ahp.entities.Empresas;
import com.uspEsalq.mba.ahp.repositories.EmpresasRepository;

@Service
public class EmpresaService {

	@Autowired
	private EmpresasRepository repository;
	
	
	public List<Empresas> findAll() {
		return repository.findAll();
	}
	
	public Empresas findById(Long id) {		
		Optional<Empresas> obj = repository.findById(id);
		return obj.get();
	}
}
