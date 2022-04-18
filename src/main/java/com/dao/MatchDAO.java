package com.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.model.Match;
import com.model.System;

@Repository
public interface MatchDAO {

	public void addTeam(Match match);
	public Match findteam(int id);
	public List<Match> findAllTeam();
	public boolean updateTeam(Match team);
	public boolean deleteTeam(int id);
	
}
