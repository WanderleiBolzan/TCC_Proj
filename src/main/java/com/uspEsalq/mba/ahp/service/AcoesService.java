package com.uspEsalq.mba.ahp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uspEsalq.mba.ahp.entities.Acoes;
import com.uspEsalq.mba.ahp.repositories.AcoesRepository;

@Service
public class AcoesService {
	
	@Autowired
	private AcoesRepository repository;
	
	public List<Acoes> findAll() {
		return repository.findAll();
	}
	
	public Acoes findById(Long id) {		
		Optional<Acoes> obj = repository.findById(id);
		return obj.get();
	}
	
	public Acoes insert(Acoes obj) {	
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public Acoes update(Long id, Acoes obj) {
		Acoes entity = repository.getReferenceById(id);
		updateData(entity, obj);
		return repository.save(entity);		
	}
	
	private void updateData(Acoes entity, Acoes obj) {
		entity.setCd_Acao(obj.getCd_Acao());
		entity.setId_Empresa(obj.getId_Empresa());
		entity.setId_Segmento(obj.getId_Segmento());
	}	
	
}
