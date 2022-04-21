package com.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class LeaderBoardExceptionController {

	@ExceptionHandler(DeleteBidderException.class)
	public ResponseEntity<?> handleDeleteException(DeleteBidderException e, WebRequest req) {
		return new ResponseEntity<>(e.toString(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(UpdateBidderException.class)
	public ResponseEntity<?> handleUpdateException(UpdateBidderException e1, WebRequest req) {
		return new ResponseEntity<>(e1.toString(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(FindBidderException.class)
	public ResponseEntity<?> handleFindException(FindBidderException e2, WebRequest req) {
		return new ResponseEntity<>(e2.toString(),HttpStatus.NOT_FOUND);
	}

}
