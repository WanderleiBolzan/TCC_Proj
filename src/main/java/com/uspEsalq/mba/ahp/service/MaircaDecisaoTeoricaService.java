package com.uspEsalq.mba.ahp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uspEsalq.mba.ahp.entities.MaricaDecisaoTeorica;
import com.uspEsalq.mba.ahp.repositories.MaircaDecisaoTeoricaRepository;

@Service
public class MaircaDecisaoTeoricaService {

	@Autowired
	private MaircaDecisaoTeoricaRepository repository;
	
	public List<MaricaDecisaoTeorica> findAll() {
		return repository.findAll();
	}
	
	public MaricaDecisaoTeorica findById(Long id) {		
		Optional<MaricaDecisaoTeorica> obj = repository.findById(id);
		return obj.get();
	}
	
	public MaricaDecisaoTeorica insert(MaricaDecisaoTeorica obj) {	
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public MaricaDecisaoTeorica update(Long id, MaricaDecisaoTeorica obj) {
		MaricaDecisaoTeorica entity = repository.getReferenceById(id); 
		updateData(entity, obj);
		return repository.save(entity);		
	}
	
	private void updateData(MaricaDecisaoTeorica entity, MaricaDecisaoTeorica obj) {
		entity.setValor(obj.getValor());
		entity.setRentabilidade(obj.getRentabilidade());
		entity.setRisco(obj.getRisco());
		entity.setVolatilidade(obj.getVolatilidade());
		entity.setLiquidez(obj.getLiquidez());
	}	
		
}
