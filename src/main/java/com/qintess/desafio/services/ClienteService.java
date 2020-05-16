package com.qintess.desafio.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qintess.desafio.entities.Cliente;
import com.qintess.desafio.repositories.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repository;
	
	//buscar todos os usuários
	public List<Cliente> findAll(){
		return repository.findAll();
	}
	
	//buscar por id
	public Cliente findById(Long id) {
		Optional <Cliente> obj = repository.findById(id);
		return obj.get();
	}
}
