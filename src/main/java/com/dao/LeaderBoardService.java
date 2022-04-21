package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.LeaderBoard;

@Service
public class LeaderBoardService {

	@Autowired
	LeaderBoardDAO leaderboardimpl;
	
	public void add(LeaderBoard team) {
		leaderboardimpl.addTeam(team);
	}
	
	public LeaderBoard findItem(int id) {
		return leaderboardimpl.findteam(id);
	}
	
	public List<LeaderBoard> findAllTeam() {
		return leaderboardimpl.findAllTeam();
	}
	
	public boolean update(LeaderBoard team) {
		return leaderboardimpl.updateTeam(team);
	}
	
	public boolean delete(int id) {
		return leaderboardimpl.deleteTeam(id);
	}
}
