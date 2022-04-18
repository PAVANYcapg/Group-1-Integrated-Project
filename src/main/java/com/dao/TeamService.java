package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Team;


@Service
public class TeamService {
	
	@Autowired
	TeamDAO teamimpl;
	
	public void add(Team team) {
		teamimpl.addTeam(team);
	}
	
	public Team findItem(int id) {
		return teamimpl.findteam(id);
	}
	
	public List<Team> findAllTeam() {
		return teamimpl.findAllTeam();
	}
	
	public boolean update(Team team) {
		return teamimpl.updateTeam(team);
	}
	
	public boolean delete(int id) {
		return teamimpl.deleteTeam(id);
	}
}
	