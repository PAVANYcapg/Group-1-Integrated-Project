package com.controller;

public class UpdateTournamentException extends RuntimeException{
	 public UpdateTournamentException() {
		super("Tournament is not avliable in database to update");
	}
	
	@Override
	public String toString() {
		return "Tournament is not avliable in database to update";
	}
}
