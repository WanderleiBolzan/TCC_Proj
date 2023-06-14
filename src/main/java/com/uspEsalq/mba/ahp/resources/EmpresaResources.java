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

import com.uspEsalq.mba.ahp.entities.Empresas;
import com.uspEsalq.mba.ahp.service.EmpresaService;

@RestController
@RequestMapping(value="/empresas")
public class EmpresaResources {

	@Autowired
	private EmpresaService service;
	
	@GetMapping
	public ResponseEntity<List<Empresas>> findAll(){
		List<Empresas> list = service.findAll(); 
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Empresas> findById(@PathVariable Long id){
		Empresas obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PostMapping
	public ResponseEntity<Empresas> insert(@RequestBody Empresas obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				 .buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);		
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Empresas> update(@PathVariable Long id, @RequestBody Empresas obj) {
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}	
}
