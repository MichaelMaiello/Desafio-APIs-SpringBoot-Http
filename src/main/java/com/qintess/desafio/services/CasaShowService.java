package com.qintess.desafio.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qintess.desafio.entities.CasaShow;
import com.qintess.desafio.repositories.CasaShowRepository;

@Service
public class CasaShowService {
	
	@Autowired
	private CasaShowRepository repository;
	
	//buscar todos os usuários
	public List<CasaShow> findAll(){
		return repository.findAll();
	}
	
	//buscar por id
	public CasaShow findById(Long id) {
		Optional <CasaShow> obj = repository.findById(id);
		return obj.get();
	}
}
