package com.uspEsalq.mba.ahp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uspEsalq.mba.ahp.entities.MaircaMatrizPeso;
import com.uspEsalq.mba.ahp.repositories.MaircaPesoRepository;

@Service
public class MaircaPesoService {
	

	@Autowired
	private MaircaPesoRepository repository;
	
	public List<MaircaMatrizPeso> findAll() {
		return repository.findAll();
	}
	
	public MaircaMatrizPeso findById(Long id) {		
		Optional<MaircaMatrizPeso> obj = repository.findById(id);
		return obj.get();
	}
	
	public MaircaMatrizPeso insert(MaircaMatrizPeso obj) {	
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public MaircaMatrizPeso update(Long id, MaircaMatrizPeso obj) {
		MaircaMatrizPeso entity = repository.getReferenceById(id); 
		updateData(entity, obj);
		return repository.save(entity);		
	}
	
	private void updateData(MaircaMatrizPeso entity, MaircaMatrizPeso obj) {
		entity.setValor(obj.getValor());
		entity.setRentabilidade(obj.getRentabilidade());
		entity.setRisco(obj.getRisco());
		entity.setVolatilidade(obj.getVolatilidade());
		entity.setLiquidez(obj.getLiquidez());
	}	

}
