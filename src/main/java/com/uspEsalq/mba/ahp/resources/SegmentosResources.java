package com.uspEsalq.mba.ahp.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.uspEsalq.mba.ahp.entities.Empresas;
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
	
	@PostMapping
	public ResponseEntity<Segmentos> insert(@RequestBody Segmentos obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				 .buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);		
	}
	
}
