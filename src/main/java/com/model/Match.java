package com.model;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Size;

@Entity
@Table(name="matchdata")
public class Match {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int matchid;
	private String teamOne;
	private String teamTwo;
	private Date date;
	private String stadium;
	private String winner;
	
@ManyToOne
private Tournaments tournaments;
	
	@ManyToOne
	private Admin admin;
	
	
	@ManyToOne
private Team team;
	
	public Match() {
}

	

	public int getMatchid() {
		return matchid;
	}



	public void setMatchid(int matchid) {
		this.matchid = matchid;
	}



	public String getTeamOne() {
		return teamOne;
	}

	public void setTeamOne(String teamOne) {
		this.teamOne = teamOne;
	}

	public String getTeamTwo() {
		return teamTwo;
	}

	public void setTeamTwo(String teamTwo) {
		this.teamTwo = teamTwo;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getStadium() {
		return stadium;
	}

	public void setStadium(String stadium) {
		this.stadium = stadium;
	}

	public String getWinner() {
		return winner;
	}

	public void setWinner(String winner) {
		this.winner = winner;
	}

	public Tournaments getTournaments() {
		return tournaments;
	}

	public void setTournaments(Tournaments tournaments) {
		this.tournaments = tournaments;
	}

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
