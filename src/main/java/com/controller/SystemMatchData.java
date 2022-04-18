package com.controller;

import com.model.Admin;
import com.model.Match;

public class SystemMatchData {

	private System system;
	private Match match;
	private Admin admin;
	
	public SystemMatchData()  {}

	public System getSystem() {
		return system;
	}

	public void setSystem(System system) {
		this.system = system;
	}

	public Match getMatch() {
		return match;
	}

	public void setMatch(Match match) {
		this.match = match;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	
	
}
