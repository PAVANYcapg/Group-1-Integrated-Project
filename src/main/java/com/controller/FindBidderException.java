package com.controller;

public class FindBidderException extends RuntimeException {

	public FindBidderException() {
		super("Bidder is not avliable in database");
	}
	
	@Override
	public String toString() {
		return "Bidder is not avliable in database";
	}

}
