package com.controller;


public class DeleteTeamException extends RuntimeException {

	private int id;
	public DeleteTeamException(int id) {
		super("id " + id + "not found");
		this.id=id;
	}
	
	@Override
	public String toString() {
		return "id " + id + "is not avaliable";
	}
	
	
	
	
}
