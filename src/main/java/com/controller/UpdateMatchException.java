package com.controller;

public class UpdateMatchException extends RuntimeException{

	public UpdateMatchException() {
		
		super("Match is not avliable in database to update");
	}
	
	@Override
	public String toString() {
		return "Match is not avliable in database to update";
	}
}
