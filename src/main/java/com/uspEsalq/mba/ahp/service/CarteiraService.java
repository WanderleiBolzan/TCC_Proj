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
	
	public Carteira insert(Carteira obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public Carteira update(Long id, Carteira obj) {
		Carteira entity = repository.getReferenceById(id);
		updateData(entity, obj);
		return repository.save(entity);		
	}
	
	private void updateData(Carteira entity, Carteira obj) {
		entity.setLiquidez(obj.getLiquidez());
		entity.setNome_ativo(obj.getNome_ativo());
		entity.setQtd_acoes(obj.getQtd_acoes());
		entity.setRentabilidade(obj.getRentabilidade());
		entity.setRisco(obj.getRisco());
		entity.setTotal_investido(obj.getTotal_investido());
		entity.setValor_cotacao(obj.getValor_cotacao());
		entity.setVolatilidade(obj.getVolatilidade());
	}
	

}
