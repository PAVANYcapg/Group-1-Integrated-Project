package com.controller;

public class UpdateSystemException extends RuntimeException{

	public UpdateSystemException() {
		
		super("System is not avliable in database to update");
	}
	
	@Override
	public String toString() {
		return "System is not avliable in database to update";
	}
}
