package com.controller;

public class FindAdminException extends RuntimeException{

	public FindAdminException() {
		super("Admin is not avliable in database");
	}
	
	@Override
	public String toString() {
		return "Admin is not avliable in database";
	}
	
}
