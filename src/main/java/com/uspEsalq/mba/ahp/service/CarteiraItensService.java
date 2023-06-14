package com.uspEsalq.mba.ahp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uspEsalq.mba.ahp.entities.CarteiraItens;
import com.uspEsalq.mba.ahp.repositories.CarteiraItemRepository;

@Service
public class CarteiraItensService {
	
	@Autowired
	private CarteiraItemRepository repository;
		
	public List<CarteiraItens> findAll() {
		return repository.findAll();
	}
	
	public CarteiraItens findById(Long id) {		
		Optional<CarteiraItens> obj = repository.findById(id);
		return obj.get();
	}
	
	public CarteiraItens insert(CarteiraItens obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public CarteiraItens update(Long id, CarteiraItens obj) {
		CarteiraItens entity = repository.getReferenceById(id);
		updateData(entity, obj);
		return repository.save(entity);		
	}
		
	private void updateData(CarteiraItens entity, CarteiraItens obj) {
		entity.setNome_ativo(obj.getNome_ativo());
		entity.setClient(obj.getClient());
		entity.setValor_contacao(obj.getValor_contacao());
		entity.setQtd_acoes(obj.getQtd_acoes());
		entity.setTotal_investido(obj.getTotal_investido());
		entity.setRentabilidade(obj.getRentabilidade());
		entity.setRisco(obj.getRisco());
		entity.setLiquidez(obj.getLiquidez());
		entity.setVolatilidade(obj.getVolatilidade());
	}	
	
}
