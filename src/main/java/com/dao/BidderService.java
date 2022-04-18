package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Bidder;

@Service
public class BidderService {

	@Autowired
	BidderDAO bidderdaoimpl;
	
	public void add(Bidder team) {
		bidderdaoimpl.addTeam(team);
	}
	
	public Bidder findTeam(int id) {
		return bidderdaoimpl.findteam(id);
	}
	
	public List<Bidder> findAllTeam() {
		return bidderdaoimpl.findAllTeam();
	}
	
	public boolean update(Bidder team) {
		return bidderdaoimpl.updateTeam(team);
	}
	
	public boolean delete(int id) {
		return bidderdaoimpl.deleteTeam(id);
	}
}
