package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Admin;

@Service
public class AdminService {
@Autowired
AdminDAO admindao;

	public void add(Admin admin) {
	admindao.addAdmin(admin);
	}

	public Admin find(int id) {
		return admindao.findadmin(id);
	}
	
	public List<Admin> findAll() {
		return admindao.findAllAdmin();
	}
	
	public boolean update(Admin admin) {
		return admindao.updateAdmin(admin);
	}
	
	public boolean delete(int id) {
		return admindao.deleteAdmin(id);
	}
	
	public boolean checkAdmin(String username, String password) {
		return admindao.checkAdmin(username, password);
	}
}
