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

import com.dao.AdminService;
import com.model.Admin;
import com.model.Team;

@RestController
public class AdminController {

	@Autowired
	AdminService adminservice;
	
	@PostMapping("/addadmin")
	public ResponseEntity<?> addAdmin(@RequestBody Admin admin) {
		adminservice.add(admin);
		return ResponseEntity.status(HttpStatus.OK).body("Admin added succesfully");
	}
	
	
	@DeleteMapping("/deleteadmin/{id}")
	public ResponseEntity<?> deleteItem(@PathVariable int id) throws DeleteAdminException {
		Admin admin=adminservice.find(id);
		if(admin==null) {
			throw new DeleteAdminException(id);
		}
		adminservice.delete(id);
		return ResponseEntity.ok("Admin deleted succesfully");
	}
	
	
	@PatchMapping("/updateadmin")
	public ResponseEntity<?> updateTeam(@RequestBody Admin admin) throws UpdateAdminException{
		Admin admin1=adminservice.find(admin.getId());
		if(admin1==null) {
			throw new UpdateAdminException();
		}
		adminservice.update(admin);
		return ResponseEntity.ok("Team updated succesfully");
	}
	
	@GetMapping("/findadmin/{id}")
	public ResponseEntity<?> findTeam(@PathVariable int id)throws FindAdminException{
		
		Admin admin2=adminservice.find(id);
		if(admin2==null) {
			throw new FindAdminException();
		}
		adminservice.find(id);
		return ResponseEntity.ok("element find succesfully");
	}
	
	@GetMapping("/findalladmin")
	public List<Admin> findAllTeam(){
		return adminservice.findAll();	
	}
}
