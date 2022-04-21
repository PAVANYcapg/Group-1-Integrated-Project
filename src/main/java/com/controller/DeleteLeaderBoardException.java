package com.controller;

public class DeleteLeaderBoardException extends RuntimeException {

	private int id;
	public DeleteLeaderBoardException(int id) {
		super("id " + id + "not found");
		this.id=id;
	}
	
	@Override
	public String toString() {
		return "id " + id + "is not avaliable";
	}
}
