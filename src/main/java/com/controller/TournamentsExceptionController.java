package com.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class TournamentsExceptionController {
	
	@ExceptionHandler(DeleteTournamentException.class)
	public ResponseEntity<?> handleDeleteException(DeleteTournamentException e, WebRequest req) {
		return new ResponseEntity<>(e.toString(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(UpdateTournamentException.class)
	public ResponseEntity<?> handleUpdateException(UpdateTournamentException f, WebRequest req) {
		return new ResponseEntity<>(f.toString(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(FindTournamentException.class)
	public ResponseEntity<?> handleFindAllException(FindTournamentException g, WebRequest req) {
		return new ResponseEntity<>(g.toString(),HttpStatus.NOT_FOUND);
	}

}
