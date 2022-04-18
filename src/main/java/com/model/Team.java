package com.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Table(name="tableteam")
public class Team {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int teamid;
	private String tname;
	private int points;
	private int ranking;
	private String statistics;
	
	@Max(value=15)
	private int noofplayers;
	
	@ManyToOne
	private System system;
	
	@OneToMany(mappedBy="matchid")
	private List<Match> matchList; 

	public Team() {}
	public int getTeamid() {
		return teamid;
	}
	public void setTeamid(int teamid) {
		this.teamid = teamid;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	public String getStatistics() {
		return statistics;
	}
	public void setStatistics(String statistics) {
		this.statistics = statistics;
	}
	
	public List<Match> getMatchList() {
		return matchList;
	}
	public void setMatchList(List<Match> matchList) {
		this.matchList = matchList;
	}
	public int getNoofplayers() {
		return noofplayers;
	}
	public void setNoofplayers(int noofplayers) {
		this.noofplayers = noofplayers;
	}
	public System getSystem() {
		return system;
	}
	public void setSystem(System system) {
		this.system = system;
	}
	public int getRanking() {
		return ranking;
	}
	public void setRanking(int ranking) {
		this.ranking = ranking;
	}
	
	
	
	

}
