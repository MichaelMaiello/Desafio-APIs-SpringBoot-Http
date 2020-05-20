package com.qintess.desafio.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.qintess.desafio.entities.CasaShow;
import com.qintess.desafio.repositories.CasaShowRepository;
import com.qintess.desafio.services.exceptions.DatabaseException;
import com.qintess.desafio.services.exceptions.ResourceNotFoundException;

@Service
public class CasaShowService {

	@Autowired
	private CasaShowRepository repository;

	// buscar todos
	public List<CasaShow> findAll() {
		return repository.findAll();
	}

	// buscar por id
	public CasaShow findById(Long id) {
		Optional<CasaShow> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	// salvar
	public CasaShow insert(CasaShow obj) {
		return repository.save(obj);
	}

	// deletar
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
}
