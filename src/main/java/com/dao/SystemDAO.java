package com.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.model.System;

@Repository

public interface SystemDAO {

	public void addSystem(System system);
	public System findSystem(int id);
	public List<System> findAllSystem();
	public boolean updateSystem(System system);
	public boolean deleteSystem(int id);
	public boolean checkSystem(int id);
}
