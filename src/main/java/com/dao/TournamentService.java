package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Tournaments;


@Service
public class TournamentService {

	@Autowired
	TournamentDAO tournamentdaoimpl;
	
	public void add(Tournaments team) {
		tournamentdaoimpl.addTeam(team);
	}
	
	public Tournaments findItem(int id) {
		return tournamentdaoimpl.findteam(id);
	}
	
	public List<Tournaments> findAllTeam() {
		return tournamentdaoimpl.findAllTeam();
	}
	
	public boolean update(Tournaments team) {
		return tournamentdaoimpl.updateTeam(team);
	}
	
	public boolean delete(int id) {
		return tournamentdaoimpl.deleteTeam(id);
	}
}
