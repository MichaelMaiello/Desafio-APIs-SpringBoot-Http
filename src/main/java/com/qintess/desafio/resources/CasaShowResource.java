package com.qintess.desafio.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qintess.desafio.entities.CasaShow;
import com.qintess.desafio.services.CasaShowService;

@RestController
@RequestMapping(value = "/casashow")
public class CasaShowResource {
	
	@Autowired
	public CasaShowService service;
	
	
	
	//End point para acessar os usuários
	@GetMapping
	public ResponseEntity<List<CasaShow>> findAll(){
		List<CasaShow> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<CasaShow> findById(@PathVariable Long id){
		CasaShow obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
