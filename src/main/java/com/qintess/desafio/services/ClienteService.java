package com.qintess.desafio.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.qintess.desafio.entities.Cliente;
import com.qintess.desafio.repositories.ClienteRepository;
import com.qintess.desafio.services.exceptions.DatabaseException;
import com.qintess.desafio.services.exceptions.ResourceNotFoundException;

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
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	//salvar
	public Cliente insert(Cliente obj) {
		return repository.save(obj);
	}
	
	//deletar
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		}catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	//Atualizar
	public Cliente update(Long id, Cliente obj) {
		try {
			Cliente entity = repository.getOne(id);
			updateData(entity, obj);
			return repository.save(entity);
		}catch (EntityNotFoundException e) {
			e.printStackTrace();
			throw new ResourceNotFoundException(id);
		}
		
	}

	private void updateData(Cliente entity, Cliente obj) {
		entity.setNome(obj.getNome());
		entity.setEmail(obj.getEmail());
		entity.setTelefone(obj.getTelefone());
	}
	
	
}
