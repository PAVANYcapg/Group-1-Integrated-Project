package com.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.model.LeaderBoard;

@Repository
public interface LeaderBoardDAO {

	public void addTeam(LeaderBoard team);
	public LeaderBoard findteam(int id);
	public List<LeaderBoard> findAllTeam();
	public boolean updateTeam(LeaderBoard team);
	public boolean deleteTeam(int id);
}
