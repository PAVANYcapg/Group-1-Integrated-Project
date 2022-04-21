package com.controller;

public class FindSystemException extends RuntimeException{

	 public FindSystemException() {
		super("Admin is not avliable in database");
	}
	
	@Override
	public String toString() {
		return "Admin is not avliable in database";
	}
}
