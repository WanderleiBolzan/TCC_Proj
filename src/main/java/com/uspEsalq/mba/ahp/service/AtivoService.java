package com.uspEsalq.mba.ahp.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uspEsalq.mba.ahp.entities.Ativos;
import com.uspEsalq.mba.ahp.entities.Segmentos;
import com.uspEsalq.mba.ahp.repositories.AtivoDataRepository;
import com.uspEsalq.mba.ahp.repositories.AtivoNomeRepository;
import com.uspEsalq.mba.ahp.repositories.AtivoRepository;
import com.uspEsalq.mba.ahp.repositories.SegmentosRepository;

@Service
public class AtivoService {
	
	@Autowired
	private AtivoRepository repository;
	
	@Autowired
	private AtivoNomeRepository repositoryAtivo;
	
	@Autowired
	private AtivoDataRepository repositoryData;
	
	@Autowired
	private SegmentosRepository repositorySegmentos;
	

	
	public List<Ativos> findAll() {
		return repository.findAll();
	}
	
	public List<Segmentos> findBySegmentos() {
		return repositorySegmentos.findAll();
	}
	

	public List<Ativos> findByAtivo(String ativo) {
		return repositoryAtivo.findByAtivo(ativo);
	}
	
	public List<Ativos> findByData(LocalDate data) {
		return repositoryData.findByData(data);
	}

	public List<Ativos> findByPerData(LocalDate data1, LocalDate data2) {
		return repositoryData.findByPerData(data1, data2);
	}
	
	public Ativos findById(Long id) {		
		Optional<Ativos> obj = repository.findById(id);
		return obj.get();
	}
	
//	public List<Ativos> findAtivosByCriadoEmEquals(LocalDateTime data) {
//		List<Ativos> obj =  repository.findAtivosByCriadoEmEquals(data);
//		return obj;
//	}
	
	public Ativos insert(Ativos obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public Ativos update(Long id, Ativos obj) {
		Ativos entity = repository.getReferenceById(id);
		updateData(entity, obj);
		return repository.save(entity);		
	}
	
	private void updateData(Ativos entity, Ativos obj) {
		entity.setAtivo(obj.getAtivo());
		entity.setId_Empresa(obj.getId_Empresa());
		entity.setId_Segmento(obj.getId_Segmento());
		entity.setData(obj.getdata()); 
		entity.setAbertura(obj.getAbertura());
		entity.setMaxima(obj.getMaxima());
		entity.setMinima(obj.getMinima());
		entity.setFechamento(obj.getFechamento());
		entity.setVolume(obj.getVolume());
		entity.setPreco_ajustado(obj.getPreco_ajustado());
		entity.setMaxima_Anterior(obj.getMaxima_Anterior());
		entity.setMinima_Anterior(obj.getMaxima_Anterior());
		entity.setCompra(obj.getCompra());
		entity.setVenda(obj.getVenda());
		entity.setResultados(obj.getResultados());
	}

}
