package com.uspEsalq.mba.ahp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.uspEsalq.mba.ahp.entities.MaricaDecisaoReal;
import com.uspEsalq.mba.ahp.repositories.MaircaDecisaoRealRepository;


public class MaircaDecisaoRealService {

	
	@Autowired
	private MaircaDecisaoRealRepository repository;
	
	public List<MaricaDecisaoReal> findAll() {
		return repository.findAll();
	}
	
	public MaricaDecisaoReal findById(Long id) {		
		Optional<MaricaDecisaoReal> obj = repository.findById(id);
		return obj.get();
	}
	
	public MaricaDecisaoReal insert(MaricaDecisaoReal obj) {	
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public MaricaDecisaoReal update(Long id, MaricaDecisaoReal obj) {
		MaricaDecisaoReal entity = repository.getReferenceById(id); 
		updateData(entity, obj);
		return repository.save(entity);		
	}
	
	private void updateData(MaricaDecisaoReal entity, MaricaDecisaoReal obj) {
		entity.setAcoes(obj.getAcoes());
		entity.setValor(obj.getValor());
		entity.setRentabilidade(obj.getRentabilidade());
		entity.setRisco(obj.getRisco());
		entity.setVolatilidade(obj.getVolatilidade());
		entity.setLiquidez(obj.getLiquidez());
	}	
	
	
	
}
