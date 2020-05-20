package com.qintess.desafio.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qintess.desafio.entities.Pedido;
import com.qintess.desafio.repositories.PedidoRepository;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository repository;
	
	//buscar todos 
	public List<Pedido> findAll(){
		return repository.findAll();
	}
	
	//buscar por id
	public Pedido findById(Long id) {
		Optional <Pedido> obj = repository.findById(id);
		return obj.get();
	}
}
