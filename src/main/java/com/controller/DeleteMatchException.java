package com.controller;

public class DeleteMatchException extends RuntimeException {
	private int id;
	public DeleteMatchException(int id) {
		super("id " + id + " not found");
		this.id=id;
	}
	
	@Override
	public String toString() {
		return "id " + id + " is not avaliable";
	}
}
