package com.controller;

public class UpdateLeaderBoardException extends RuntimeException {

	 public UpdateLeaderBoardException() {
		
		super("LeaderBoard is not avliable in database to update");
	}
	
	@Override
	public String toString() {
		return "LeaderBoard is not avliable in database to update";
	}
}
