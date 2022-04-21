package com.controller;

public class FindLeaderBoardException extends RuntimeException{

	public FindLeaderBoardException() {
		super("LeaderBoard is not avliable in database");
	}
	
	@Override
	public String toString() {
		return "Bidder is not avliable in database";
	}
}
