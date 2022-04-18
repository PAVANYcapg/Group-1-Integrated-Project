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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dao.AdminService;
import com.dao.MatchService;
import com.dao.SystemService;
import com.model.Admin;
import com.model.Match;

@RestController
public class SystemRestController {

	@Autowired
	MatchService matchservice;
	
	@Autowired
	SystemService systemservice;
	
	@Autowired
	AdminService adminservice;
	
	@PostMapping("/addmatch")
	public ResponseEntity<?> addMatch(@RequestBody SystemMatchData matchdata) {
		boolean result=systemservice.checkSystem(matchdata.getAdmin().getId());
		if(result) {
		matchservice.add(matchdata.getMatch());
		return ResponseEntity.status(HttpStatus.OK).body("Match added by System succesfully");
		}
		else {
			return ResponseEntity.status(HttpStatus.OK).body("Invalid System details");
		}
	}
	
	
	@DeleteMapping("/deletematch")
	public ResponseEntity<?> deleteMatch(@RequestBody SystemMatchData matchdata) throws DeleteMatchException  {
		boolean result=systemservice.checkSystem(matchdata.getAdmin().getId());
		if(result) {
			Match match=matchservice.findItem(matchdata.getMatch().getMatchid());
			if(match==null) {
				throw new DeleteMatchException(match.getMatchid());
			}
			matchservice.delete(match.getMatchid());
			return ResponseEntity.ok("Match deleted succesfully");
		}
		else {
			return ResponseEntity.ok("element not found to delete");
			}
	}
	
	
	@PatchMapping("/updatematch")
	public ResponseEntity<?> updateTeam(@RequestBody SystemMatchData matchdata) throws UpdateMatchException{
		boolean result=systemservice.checkSystem(matchdata.getAdmin().getId());
		if(result) {
		Match match1=matchservice.findItem(matchdata.getMatch().getMatchid());
		if(match1==null) {
			throw new UpdateMatchException();
		}
		matchservice.update(matchdata.getMatch());
		return ResponseEntity.ok("Match updated succesfully");
		}
		else {
			return ResponseEntity.ok("element not found to update");
		}
	}
	
	@GetMapping("/findmatch")
	public ResponseEntity<?> findTeam(@RequestBody SystemMatchData matchdata)throws FindMatchException{
		boolean result=systemservice.checkSystem(matchdata.getAdmin().getId());
		if(result) {
		
			Match match2=matchservice.findItem(matchdata.getMatch().getMatchid());
			if(match2==null) {
				throw new FindMatchException();
			}
			matchservice.findItem(match2.getMatchid());
			return ResponseEntity.ok("element find succesfully");
		}
		else {
			return ResponseEntity.ok("element not found ");
		}
	}
	
	@GetMapping("/findallmatch")
	public List<Match> findAllTeam(@RequestBody SystemMatchData matchdata){
		boolean result=systemservice.checkSystem(matchdata.getAdmin().getId());
		if(result) {
		return matchservice.findAllTeam();	
		}
		return matchservice.findAllTeam();
	}
	
	
}