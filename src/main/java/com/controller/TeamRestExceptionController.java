package com.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class TeamRestExceptionController {

	@ExceptionHandler(DeleteTeamException.class)
	public ResponseEntity<?> handleDeleteException(DeleteTeamException e, WebRequest req) {
		return new ResponseEntity<>(e.toString(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(UpdateTeamException.class)
	public ResponseEntity<?> handleUpdateException(UpdateTeamException f, WebRequest req) {
		return new ResponseEntity<>(f.toString(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(FindAllTeamException.class)
	public ResponseEntity<?> handleFindAllException(FindAllTeamException g, WebRequest req) {
		return new ResponseEntity<>(g.toString(),HttpStatus.NOT_FOUND);
	}
}
