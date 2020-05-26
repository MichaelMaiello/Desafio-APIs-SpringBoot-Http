package com.qintess.desafio.resources;

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
	
	@PostMapping
	public ResponseEntity<CasaShow> insert(@RequestBody CasaShow obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<CasaShow> update(@PathVariable Long id, @RequestBody CasaShow obj){
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
}
