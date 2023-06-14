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
		
	public Empresas insert(Empresas obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public Empresas update(Long id, Empresas obj) {
		Empresas entity = repository.getReferenceById(id);
		updateData(entity, obj);
		return repository.save(entity);		
	}
	
	private void updateData(Empresas entity, Empresas obj) {
		entity.setId(obj.getId());
		entity.setId_Segmento(obj.getId_Segmento());
		entity.setRazao_Social(obj.getRazao_Social());
		entity.setAcao(obj.getAcao());
	}
	
}
