package com.uspEsalq.mba.ahp.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
