package com.controller;

public class FindMatchException extends RuntimeException{
	public FindMatchException() {
		super("Match is not avliable in database");
	}
	
	@Override
	public String toString() {
		return "Match is not avliable in database";
	}
}
