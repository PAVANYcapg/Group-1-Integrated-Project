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

import com.dao.SystemService;
import com.model.Admin;
import com.model.System;

@RestController
public class SystemController {

	@Autowired
	SystemService systemservice;
	
	@PostMapping("/addsystem")
	public ResponseEntity<?> addSystem(@RequestBody System system) {
		systemservice.add(system);
		return ResponseEntity.status(HttpStatus.OK).body("System added succesfully");
	}
	
	@DeleteMapping("/deletesystem/{id}")
	public ResponseEntity<?> deleteSystem(@PathVariable int id) throws DeleteSystemException {
		System system=systemservice.find(id);
		if(system==null) {
			throw new DeleteSystemException(id);
		}
		systemservice.delete(id);
		return ResponseEntity.ok("System deleted succesfully");
	}
	
	@PatchMapping("/updatesystem")
	public ResponseEntity<?> updateSystem(@RequestBody System system) throws UpdateSystemException{
		System system1=systemservice.find(system.getSystemid());
		if(system1==null) {
			throw new UpdateSystemException();
		}
		systemservice.update(system);
		return ResponseEntity.ok("System updated succesfully");
	}
	
	@GetMapping("/findsystem/{id}")
	public ResponseEntity<?> findSystem(@PathVariable int id)throws FindSystemException{
		
		System system2=systemservice.find(id);
		if(system2==null) {
			throw new FindSystemException();
		}
		systemservice.find(id);
		return ResponseEntity.ok("System find succesfully");
	}
	
	@GetMapping("/findallsystem")
	public List<System> findAllSystem(){
		return systemservice.findAllSystem();	
	}
}
