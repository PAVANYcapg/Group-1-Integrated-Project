package com.controller;

import com.model.Admin;
import com.model.Team;

public class TeamData {

	private Admin admin;
	private Team team;
	
	public TeamData() {}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}
	
	
}
