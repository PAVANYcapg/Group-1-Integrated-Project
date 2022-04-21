package com.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.model.Team;

@Repository
public interface TeamDAO {
	
	public void addTeam(Team team);
	public Team findteam(int id);
	public List<Team> findAllTeam();
	public boolean updateTeam(Team team);
	public boolean deleteTeam(int id);
}	
