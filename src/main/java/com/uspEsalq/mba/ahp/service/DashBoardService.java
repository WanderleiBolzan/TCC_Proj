package com.uspEsalq.mba.ahp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uspEsalq.mba.ahp.entities.DashBoard;
import com.uspEsalq.mba.ahp.repositories.DashBoardRepository;

@Service
public class DashBoardService {
	
	@Autowired
	private DashBoardRepository repository;
	
	public List<DashBoard> findAll() {
		return repository.findAll();
	}
	
	public DashBoard findById(Long id) {		
		Optional<DashBoard> obj = repository.findById(id);
		return obj.get();
	}
	
	public DashBoard insert(DashBoard obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
}
