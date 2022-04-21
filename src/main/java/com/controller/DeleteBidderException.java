package com.controller;

public class DeleteBidderException extends RuntimeException{

	private int id;
	public DeleteBidderException(int id) {
		super("id " + id + "not found");
		this.id=id;
	}
	
	@Override
	public String toString() {
		return "id " + id + "is not avaliable";
	}

}
