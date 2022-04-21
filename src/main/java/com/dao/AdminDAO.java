package com.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.model.Admin;
@Repository
public interface AdminDAO {
	public void addAdmin(Admin admin);
	public Admin findadmin(int id);
	public List<Admin> findAllAdmin();
	public boolean updateAdmin(Admin admin);
	public boolean deleteAdmin(int id);	
	public boolean checkAdmin(String username,String password);

}
