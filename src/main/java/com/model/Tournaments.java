package com.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Tournaments {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int tournamentid;
	
	@NotNull(message="No of teams cannot be null")
	private int numOfTeams;
	
	@NotNull(message="duration cannot be null")
	private Date duration;
	
	@OneToMany(mappedBy="matchid")
	private List<Match> matchList;
	
	public Tournaments()  {}

	public int getTournamentid() {
		return tournamentid;
	}

	public void setTournamentid(int tournamentid) {
		this.tournamentid = tournamentid;
	}

	public int getNumOfTeams() {
		return numOfTeams;
	}

	public void setNumOfTeams(int numOfTeams) {
		this.numOfTeams = numOfTeams;
	}

	public Date getDuration() {
		return duration;
	}

	public void setDuration(Date i) {
		this.duration = i;
	}

	public List<Match> getMatchList() {
		return matchList;
	}

	public void setMatchList(List<Match> matchList) {
		this.matchList = matchList;
	}
	
	
	
}
