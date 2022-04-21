package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dao.BidderService;
import com.dao.LeaderBoardService;
import com.model.Bidder;
import com.model.LeaderBoard;

@RestController
public class LeaderBoardRestController {

	@Autowired
	LeaderBoardService leaderboardservice;
	
	@PostMapping("/addleaderboard")
	public ResponseEntity<?> addTeam(@RequestBody LeaderBoard leaderboard) {
		leaderboardservice.add(leaderboard);
		return ResponseEntity.status(HttpStatus.OK).body("LeaderBoard added succesfully");
	}
	
	
	@DeleteMapping("/deleteleaderboard/{id}")
	public ResponseEntity<?> deleteItem(@PathVariable int id) throws DeleteLeaderBoardException {
		LeaderBoard leaderboard=leaderboardservice.findItem(id);
		if(leaderboardservice==null) {
			throw new DeleteLeaderBoardException(id);
		}
		leaderboardservice.delete(id);
		return ResponseEntity.ok("LeaderBoard deleted succesfully");
	}
	
	
	@PatchMapping("/updateleaderboard")
	public ResponseEntity<?> updateTeam(@RequestBody LeaderBoard leaderboard) throws UpdateLeaderBoardException{
		LeaderBoard leaderboard1=leaderboardservice.findItem(leaderboard.getBidderId());
		if(leaderboard==null) {
			throw new UpdateLeaderBoardException();
		}
		leaderboardservice.update(leaderboard);
		return ResponseEntity.ok("LeaderBoard updated succesfully");
	}
	
	@GetMapping("/findleaderboard/{id}")
	public ResponseEntity<?> findBidder(@PathVariable int id)throws FindLeaderBoardException{
		
		LeaderBoard leaderboard=leaderboardservice.findItem(id);
		if(leaderboard==null) {
			throw new FindBidderException();
		}
		leaderboardservice.findItem(id);
		return ResponseEntity.ok("element find succesfully");
	}
	
	@GetMapping("/findallleaderboard")
	public List<LeaderBoard> findAllTeam(){
		return leaderboardservice.findAllTeam();	
	}
}
