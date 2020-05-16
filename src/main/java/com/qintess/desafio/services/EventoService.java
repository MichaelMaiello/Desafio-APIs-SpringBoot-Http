package com.qintess.desafio.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qintess.desafio.entities.Evento;
import com.qintess.desafio.repositories.EventoRepository;

@Service
public class EventoService {
	
	@Autowired
	private EventoRepository repository;
	
	//buscar todos os usuários
	public List<Evento> findAll(){
		return repository.findAll();
	}
	
	//buscar por id
	public Evento findById(Long id) {
		Optional <Evento> obj = repository.findById(id);
		return obj.get();
	}
}
