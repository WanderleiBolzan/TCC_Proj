package com.uspEsalq.mba.ahp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uspEsalq.mba.ahp.entities.Segmentos;
import com.uspEsalq.mba.ahp.repositories.SegmentosRepository;

@Service
public class SegmentosService {
	
	@Autowired
	private SegmentosRepository repository;
	
	
	public List<Segmentos> findAll() {
		return repository.findAll();
	}
	
	public Segmentos findById(Long id) {		
		Optional<Segmentos> obj = repository.findById(id);
		return obj.get();
	}

}
