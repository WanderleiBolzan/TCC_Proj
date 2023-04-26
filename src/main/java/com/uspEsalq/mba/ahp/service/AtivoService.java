package com.uspEsalq.mba.ahp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uspEsalq.mba.ahp.entities.Ativos;
import com.uspEsalq.mba.ahp.repositories.AtivosRepository;

@Service
public class AtivoService {
	
	@Autowired
	private AtivosRepository repository;
	
	
	public List<Ativos> findAll() {
		return repository.findAll();
	}
	
	public Ativos findById(Long id) {		
		Optional<Ativos> obj = repository.findById(id);
		return obj.get();
	}

}
