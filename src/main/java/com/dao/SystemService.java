package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.System;


@Service
public class SystemService {

	@Autowired
	SystemDAO systemdaoimpl;
	
	public void add(System system) {
		systemdaoimpl.addSystem(system);
	}
	
	public System find(int id) {
		return systemdaoimpl.findSystem(id);
	}
	
	public List<System> findAllSystem() {
		return systemdaoimpl.findAllSystem();
	}
	
	public boolean update(System system) {
		return systemdaoimpl.updateSystem(system);
	}
	
	public boolean delete(int id) {
		return systemdaoimpl.deleteSystem(id);
	}
	
	public boolean checkSystem(int id) {
		return systemdaoimpl.checkSystem(id);
	}
}