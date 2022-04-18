package com.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
//@Table(name="admintable")
public class Admin {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String username;
	private String password;
	
	@OneToOne
	private System system;
	
	@OneToMany(mappedBy="matchid")
	private List<Match> matchList;

	public Admin() {	
	}
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public System getSystem() {
		return system;
	}

	public void setSystem(System system) {
		this.system = system;
	}
	public List<Match> getMatchList() {
		return matchList;
	}

	public void setMatchList(List<Match> matchList) {
		this.matchList = matchList;
	}	
	
}