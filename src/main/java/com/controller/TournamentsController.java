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

import com.dao.TournamentService;
import com.model.Admin;
import com.model.Tournaments;

@RestController
public class TournamentsController {

	@Autowired
	TournamentService tourservice;
	
	@PostMapping("/addatournaments")
	public ResponseEntity<?> addAdmin(@RequestBody Tournaments tournaments) {
		tourservice.add(tournaments);
		return ResponseEntity.status(HttpStatus.OK).body("Tournaments added succesfully");
	}
	
	
	@DeleteMapping("/deletetournament/{id}")
	public ResponseEntity<?> deleteItem(@PathVariable int id) throws DeleteTournamentException {
		Tournaments tour=tourservice.findItem(id);
		if(tour==null) {
			throw new DeleteTournamentException(id);
		}
		tourservice.delete(id);
		return ResponseEntity.ok("Tournaments deleted succesfully");
	}
	
	
	@PatchMapping("/updatetournament")
	public ResponseEntity<?> updateTeam(@RequestBody Tournaments tournaments) throws UpdateTournamentException{
		Tournaments tour1=tourservice.findItem(tournaments.getTournamentid());
		if(tour1==null) {
			throw new UpdateTournamentException();
		}
		tourservice.update(tournaments);
		return ResponseEntity.ok("Tournaments updated succesfully");
	}
	
	@GetMapping("/findtournament/{id}")
	public ResponseEntity<?> findTeam(@PathVariable int id)throws FindTournamentException{
		
		Tournaments tour2=tourservice.findItem(id);
		if(tour2==null) {
			throw new FindTournamentException();
		}
		tourservice.findItem(id);
		return ResponseEntity.ok("Tournaments find succesfully");
	}
	
	@GetMapping("/findalltournament")
	public List<Tournaments> findAllTeam(){
		return tourservice.findAllTeam();	
	}
}
