package com.uspEsalq.mba.ahp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uspEsalq.mba.ahp.entities.Carteira;
import com.uspEsalq.mba.ahp.repositories.CarteirasRepository;

@Service
public class CarteiraService {
	
	@Autowired
	private CarteirasRepository repository;
	
	
	public List<Carteira> findAll() {
		return repository.findAll();
	}
	
	public Carteira findById(Long id) {		
		Optional<Carteira> obj = repository.findById(id);
		return obj.get();
	}
	

}
