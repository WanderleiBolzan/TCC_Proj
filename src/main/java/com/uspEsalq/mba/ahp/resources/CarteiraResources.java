package com.uspEsalq.mba.ahp.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uspEsalq.mba.ahp.entities.Carteira;
import com.uspEsalq.mba.ahp.service.CarteiraService;

@RestController
@RequestMapping(value="/carteiras")
public class CarteiraResources {

	@Autowired
	private CarteiraService service;
	
	@GetMapping
	public ResponseEntity<List<Carteira>> findAll(){
		List<Carteira> list = service.findAll(); 
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Carteira> findById(@PathVariable Long id){
		Carteira obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
