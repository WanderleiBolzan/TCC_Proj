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

	public Segmentos insert(Segmentos obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public Segmentos update(Long id, Segmentos obj) {
		Segmentos entity = repository.getReferenceById(id);
		updateData(entity, obj);
		return repository.save(entity);		
	}
	
	private void updateData(Segmentos entity, Segmentos obj) {
//		entity.set(obj.getId_Segmento());
//		entity.setRazao_Social(obj.getRazao_Social());
	}
	
}
