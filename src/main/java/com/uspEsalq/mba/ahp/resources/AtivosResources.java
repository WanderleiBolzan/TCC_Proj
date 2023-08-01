package com.uspEsalq.mba.ahp.resources;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.uspEsalq.mba.ahp.entities.Ativos;
import com.uspEsalq.mba.ahp.service.AtivoService;


@RestController
//@CrossOrigin(origins="*")
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

  	@GetMapping(value = "/nome")
  	public ResponseEntity<List<Ativos>> findByAtivo(@RequestParam(name = "ativo") String ativo){
 		List<Ativos> list = service.findByAtivo(ativo);
  		return ResponseEntity.ok().body(list);
 	}
  	
 	
  	@GetMapping(value = "/data")
  	public ResponseEntity<List<Ativos>> findByData(@RequestParam(name = "data") LocalDate data){
 		List<Ativos> list = service.findByData(data);
  		return ResponseEntity.ok().body(list);
 	}

  	@GetMapping(value = "/")
  	public ResponseEntity<List<Ativos>> findByPerData(@RequestParam(name = "data") LocalDate data1, LocalDate data2){
 		List<Ativos> list = service.findByPerData(data1, data2);
  		return ResponseEntity.ok().body(list);
 	}
  	
 	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PostMapping
	public ResponseEntity<Ativos> insert(@RequestBody Ativos obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				 .buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);		
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Ativos> update(@PathVariable Long id, @RequestBody Ativos obj) {
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}	
	
}
