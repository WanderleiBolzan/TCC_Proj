package com.uspEsalq.mba.ahp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.uspEsalq.mba.ahp.entities.MaircaRanking;
import com.uspEsalq.mba.ahp.repositories.MaircaRankingRepository;


public class MaircaRankingService {

	@Autowired
	private MaircaRankingRepository repository;
	
	public List<MaircaRanking> findAll() {
		return repository.findAll();
	}
	
	public MaircaRanking findById(Long id) {		
		Optional<MaircaRanking> obj = repository.findById(id);
		return obj.get();
	}
	
	public MaircaRanking insert(MaircaRanking obj) {	
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public MaircaRanking update(Long id, MaircaRanking obj) {
		MaircaRanking entity = repository.getReferenceById(id); 
		updateData(entity, obj);
		return repository.save(entity);		
	}
	
	private void updateData(MaircaRanking entity, MaircaRanking obj) {
		entity.setAcao(obj.getAcao());
		entity.setSomaGap(obj.getSomaGap());
		entity.setRanking(obj.getRanking());
	}	
	
}
