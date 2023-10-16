package com.uspEsalq.mba.ahp.resources;

import java.net.URI;
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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.uspEsalq.mba.ahp.entities.MaircaMatrizPeso;
import com.uspEsalq.mba.ahp.service.MaircaPesoService;


@RestController
@RequestMapping(value="/matrizPeso")
public class MaircaPesoResource {

	@Autowired
	private MaircaPesoService service;
		
	@GetMapping
	public ResponseEntity<List<MaircaMatrizPeso>> findAll(){
		List<MaircaMatrizPeso> list = service.findAll(); 
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<MaircaMatrizPeso> findById(@PathVariable Long id){
		MaircaMatrizPeso obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
		
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
		
	@PostMapping
	public ResponseEntity<MaircaMatrizPeso> insert(@RequestBody MaircaMatrizPeso obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				 .buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);		
	}
		
	@PutMapping(value = "/{id}")
	public ResponseEntity<MaircaMatrizPeso> update(@PathVariable Long id, @RequestBody MaircaMatrizPeso obj) {
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}	
}
