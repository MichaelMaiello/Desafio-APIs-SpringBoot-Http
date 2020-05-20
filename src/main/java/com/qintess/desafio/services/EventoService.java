package com.qintess.desafio.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.qintess.desafio.entities.Evento;
import com.qintess.desafio.repositories.EventoRepository;
import com.qintess.desafio.services.exceptions.DatabaseException;
import com.qintess.desafio.services.exceptions.ResourceNotFoundException;

@Service
public class EventoService {

	@Autowired
	private EventoRepository repository;

	// buscar todos os usuários
	public List<Evento> findAll() {
		return repository.findAll();
	}

	// buscar por id
	public Evento findById(Long id) {
		Optional<Evento> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	// salvar
	public Evento insert(Evento obj) {
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
}
