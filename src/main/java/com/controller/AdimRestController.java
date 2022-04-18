package com.controller;

import java.util.List;

import javax.persistence.PostUpdate;

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

import com.dao.AdminService;
import com.dao.TeamService;
import com.model.Admin;
import com.model.Team;

@RestController
public class AdimRestController {
	@Autowired
	AdminService adminservice;
	@Autowired
	TeamService teamservice;

	@PostMapping("/addviaadmin")
	public ResponseEntity<?> addTeam(@RequestBody TeamData teamdata){
		boolean result=adminservice.checkAdmin(teamdata.getAdmin().getUsername(), teamdata.getAdmin().getPassword());
		if(result) {
			teamservice.add(teamdata.getTeam());
			return ResponseEntity.status(HttpStatus.OK).body("Added By Admin Succesfully");
		}
		else {
			return ResponseEntity.status(HttpStatus.OK).body("Invalid Admin details");
		}	
	}
	
	@DeleteMapping("/deleteteam")
	public ResponseEntity<?> deleteTeam(@RequestBody TeamData teamdata) throws DeleteTeamException{
		boolean result=adminservice.checkAdmin(teamdata.getAdmin().getUsername(), teamdata.getAdmin().getPassword());
		if(result) {
			Team team = teamservice.findItem(teamdata.getTeam().getTeamid());
			if(team==null)
			{
				throw new DeleteTeamException(team.getTeamid());
			}
			teamservice.delete(team.getTeamid());
			return ResponseEntity.ok("element deleted succesfully");
		}
		else {
			return ResponseEntity.ok("element not found to delete");
		}
	}
	
	@PatchMapping("/manageteam")
	public ResponseEntity<?> updateTeam(@RequestBody TeamData teamdata) throws UpdateTeamException {
		boolean result=adminservice.checkAdmin(teamdata.getAdmin().getUsername(), teamdata.getAdmin().getPassword());
		if(result) {
			Team team1 = teamservice.findItem(teamdata.getTeam().getTeamid());
			if(team1==null) {
				throw new UpdateTeamException();
			}
		
			teamservice.update(teamdata.getTeam());
			return ResponseEntity.ok("Team updated succesfully");
		}
		else {
			return ResponseEntity.ok("Team not found to update");
		}
	}
	
	@GetMapping("/findteam")
	public ResponseEntity<?> findTeam(@RequestBody TeamData teamdata){
		boolean result=adminservice.checkAdmin(teamdata.getAdmin().getUsername(), teamdata.getAdmin().getPassword());
		if(result) {
			Team team2=teamservice.findItem(teamdata.getTeam().getTeamid());
			if(team2==null) {
				throw new FindAllTeamException();
			}
			teamservice.findItem(team2.getTeamid());
			return ResponseEntity.ok("element find succesfully");
		}
		else {
			return ResponseEntity.ok("element not Found");
		}
	}
	
	@GetMapping("/findallteam")
	public List<Team> findAllTeam(@RequestBody TeamData teamdata){
		boolean result=adminservice.checkAdmin(teamdata.getAdmin().getUsername(), teamdata.getAdmin().getPassword());
		if(result) {
			return teamservice.findAllTeam();	
		}
		return teamservice.findAllTeam();
		
	}
	
	
	
	
	
	
	
	
}
