package com.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.model.Bidder;

@Repository
public interface BidderDAO {

	public void addTeam(Bidder team);
	public Bidder findteam(int id);
	public List<Bidder> findAllTeam();
	public boolean updateTeam(Bidder team);
	public boolean deleteTeam(int id);
}
