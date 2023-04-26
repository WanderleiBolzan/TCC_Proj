package com.uspEsalq.mba.ahp.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uspEsalq.mba.ahp.entities.Ativos;
import com.uspEsalq.mba.ahp.service.AtivoService;

@RestController
@RequestMapping(value="/ativos")
public class AtivosResources {

	@Autowired
	private AtivoService service;
	
	@GetMapping
	public ResponseEntity<List<Ativos>> findAll(){
		List<Ativos> list = service.findAll(); 
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Ativos> findById(@PathVariable Long id){
		Ativos obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
