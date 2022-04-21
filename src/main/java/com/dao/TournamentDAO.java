package com.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.model.Tournaments;

@Repository
public interface TournamentDAO {

	public void addTeam(Tournaments team);
	public Tournaments findteam(int id);
	public List<Tournaments> findAllTeam();
	public boolean updateTeam(Tournaments team);
	public boolean deleteTeam(int id);
}
