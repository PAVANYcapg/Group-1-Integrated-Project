package com.controller;

public class UpdateAdminException extends RuntimeException{
	
	public UpdateAdminException() {
	
		super("Admin is not avliable in database to update");
	}
	
	@Override
	public String toString() {
		return "Admin is not avliable in database to update";
	}
}
