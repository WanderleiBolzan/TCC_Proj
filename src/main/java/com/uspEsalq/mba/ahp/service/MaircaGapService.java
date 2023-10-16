package com.uspEsalq.mba.ahp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.uspEsalq.mba.ahp.entities.MaircaGap;
import com.uspEsalq.mba.ahp.repositories.MaircaGapRepository;

public class MaircaGapService {

	@Autowired
	private MaircaGapRepository repository;
	
	public List<MaircaGap> findAll() {
		return repository.findAll();
	}
	
	public MaircaGap findById(Long id) {		
		Optional<MaircaGap> obj = repository.findById(id);
		return obj.get();
	}
	
	public MaircaGap insert(MaircaGap obj) {	
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public MaircaGap update(Long id, MaircaGap obj) {
		MaircaGap entity = repository.getReferenceById(id); 
		updateData(entity, obj);
		return repository.save(entity);		
	}
	
	private void updateData(MaircaGap entity, MaircaGap obj) {
		entity.setAcoes(obj.getAcoes());
		entity.setValor(obj.getValor());
		entity.setRentabilidade(obj.getRentabilidade());
		entity.setRisco(obj.getRisco());
		entity.setVolatilidade(obj.getVolatilidade());
		entity.setLiquidez(obj.getLiquidez());
	}	
}
