package com.controller;

public class FindTournamentException extends RuntimeException{

	public FindTournamentException() {
		super("Admin is not avliable in database");
	}
	
	@Override
	public String toString() {
		return "Admin is not avliable in database";
	}
}
