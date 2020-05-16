package com.qintess.desafio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qintess.desafio.entities.Evento;

public interface EventoRepository extends JpaRepository<Evento, Long>{

}
