package com.controller;

public class DeleteTournamentException extends RuntimeException{

	private int id;
	 public DeleteTournamentException(int id) {
		super("id " + id + "not found");
		this.id=id;
	}
	
	@Override
	public String toString() {
		return "id " + id + "is not avaliable";
	}
}
