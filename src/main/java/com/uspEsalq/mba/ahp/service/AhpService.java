package com.uspEsalq.mba.ahp.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uspEsalq.mba.ahp.entities.Ahp;
import com.uspEsalq.mba.ahp.entities.Segmentos;
import com.uspEsalq.mba.ahp.repositories.AhpDataRepository;
import com.uspEsalq.mba.ahp.repositories.AhpNomeRepository;
import com.uspEsalq.mba.ahp.repositories.AhpRepository;
import com.uspEsalq.mba.ahp.repositories.SegmentosRepository;

@Service
public class AhpService {
	
	@Autowired
	private AhpRepository repository;
	
	@Autowired
	private AhpNomeRepository repositoryAtivo;
	
	@Autowired
	private SegmentosRepository repositorySegmentos;
	
	@Autowired
	private AhpDataRepository ahpDataRepository;
	
	public List<Ahp> findAll() {
		return repository.findAll();
	}
	
	public List<Segmentos> findBySegmentos() {
		return repositorySegmentos.findAll();
	}
	
	public List<Ahp> findByAtivo(String ativo) {
		return repositoryAtivo.findByAtivo(ativo);
	}
	
	
	public Ahp findById(Long id) {		
		Optional<Ahp> obj = repository.findById(id);
		return obj.get();
	}
	
	public List<Ahp> findByData(LocalDate data) {
		return ahpDataRepository.findByData(data);
	}
	
	
	public Ahp insert(Ahp obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public Ahp update(Long id, Ahp obj) {
		Ahp entity = repository.getReferenceById(id);
		updateData(entity, obj);
		return repository.save(entity);		
	}
	
	private void updateData(Ahp entity, Ahp obj) {	
		entity.setAtivo(obj.getAtivo());
		entity.setData(obj.getData());
		entity.setId_Segmento(obj.getId_Segmento()); 
		entity.setId_Empresa(obj.getId_Empresa());
		entity.setMaxima(obj.getMaxima());
		entity.setMinima(obj.getMinima());
		entity.setDataCompra(obj.getDataCompra());
		entity.setCotacao(obj.getCotacao());
		entity.setQtdAcoes(obj.getQtdAcoes());
		entity.setTotInvest(obj.getTotInvest());
		entity.setCotacaoAtual(obj.getCotacaoAtual());
		entity.setValorAtual(obj.getValorAtual());
		entity.setRentabilidade(obj.getRentabilidade());
		entity.setRisco(obj.getRisco());
		entity.setLiquidez(obj.getLiquidez());
		entity.setVolatilidade(obj.getVolatilidade());
	}
}
