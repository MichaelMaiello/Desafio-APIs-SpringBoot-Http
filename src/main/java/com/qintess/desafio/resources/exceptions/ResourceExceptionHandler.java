package com.qintess.desafio.resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.qintess.desafio.services.exceptions.DatabaseException;
import com.qintess.desafio.services.exceptions.ResourceNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandarError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest resquest){
		String error = "Resource not found";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandarError err = new StandarError(Instant.now(), status.value(), error, e.getMessage(), resquest.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
	
	//Delete
	@ExceptionHandler(DatabaseException.class)
	public ResponseEntity<StandarError> database(DatabaseException e, HttpServletRequest resquest){
		String error = "Database error";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandarError err = new StandarError(Instant.now(), status.value(), error, e.getMessage(), resquest.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
	
	//Update
	

}
