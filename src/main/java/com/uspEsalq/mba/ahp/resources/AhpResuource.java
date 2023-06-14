package com.uspEsalq.mba.ahp.resources;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

import com.uspEsalq.mba.ahp.entities.Ahp;
import com.uspEsalq.mba.ahp.entities.Ativos;
import com.uspEsalq.mba.ahp.entities.Segmentos;
import com.uspEsalq.mba.ahp.service.AhpService;
import com.uspEsalq.mba.ahp.service.AtivoService;


@RestController
@RequestMapping(value="/ahp")
public class AhpResuource {

	@Autowired
	private AhpService service;
	
			
	@GetMapping
	public ResponseEntity<List<Ahp>> findAll(){
		List<Ahp> list = service.findAll(); 
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Ahp> findById(@PathVariable Long id){
		Ahp obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

  	@GetMapping(value = "/nome")
  	public ResponseEntity<List<Ahp>> findByAtivo(@RequestParam(name = "ativo") String ativo){
 		List<Ahp> list = service.findByAtivo(ativo);
  		return ResponseEntity.ok().body(list);
 	}
	
  	@GetMapping(value = "/data")
  	public ResponseEntity<List<Ahp>> findByData(@RequestParam(name = "data") LocalDate data){
 		List<Ahp> list = service.findByData(data);
  		return ResponseEntity.ok().body(list);
 	}
  	
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PostMapping
	public ResponseEntity<Ahp> insert(@RequestBody Ahp obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				 .buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);		
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Ahp> update(@PathVariable Long id, @RequestBody Ahp obj) {
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}		
}
