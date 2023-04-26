package com.uspEsalq.mba.ahp.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uspEsalq.mba.ahp.entities.Segmentos;
import com.uspEsalq.mba.ahp.service.SegmentosService;

@RestController
@RequestMapping(value="/segmentos")
public class SegmentosResources {

	@Autowired
	private SegmentosService service;
	
	@GetMapping
	public ResponseEntity<List<Segmentos>> findAll(){
		List<Segmentos> list = service.findAll(); 
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Segmentos> findById(@PathVariable Long id){
		Segmentos obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
