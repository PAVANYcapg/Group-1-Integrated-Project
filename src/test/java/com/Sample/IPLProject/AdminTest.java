package com.Sample.IPLProject;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.dao.AdminService;
import com.model.Admin;

import junit.framework.Assert;

@SpringBootTest
class AdminTest {
	
	@Autowired
	AdminService adminservice;

	@Test
	void testAdd() {
		Admin admin = new Admin();
		admin.setUsername("Ranjan");
		admin.setPassword("@123");
		adminservice.add(admin);
		
		Admin admin_to_be_tested = adminservice.find(admin.getId());
		Assert.assertEquals("Ranjan", admin_to_be_tested.getUsername());
		Assert.assertEquals("@123", admin_to_be_tested.getPassword());
	}

	@Test
	void testFind() {
		Admin admin1 = new Admin();
		admin1.setUsername("Pradeep");
		admin1.setPassword("@1234");
		adminservice.add(admin1);
		
		Admin admin_to_be_tested = adminservice.find(admin1.getId());
		Assert.assertEquals("Pradeep", admin_to_be_tested.getUsername());
		Assert.assertEquals("@1234", admin_to_be_tested.getPassword());
	}

	@Test
	void testFindAll() {
		Admin admin = new Admin();
		admin.setUsername("Pavan");
		admin.setPassword("@12345");
		adminservice.add(admin);
		
		List<Admin> add =  adminservice.findAll();
		Assert.assertEquals("Pavan", add.get(1).getUsername());
	}

	@Test
	void testUpdate() {
		Admin admin=new Admin();
		admin.setUsername("Chitira");
		admin .setPassword("#20101");
		adminservice.add(admin);
		adminservice.update(admin);

		//Admin to_be_tested = adminservice.update(admin.getAdmin());
		Assert.assertEquals(true, adminservice.update(admin));
	}

	@Test
	void testDelete() {
		
		adminservice.delete(2);
		Admin admin4 = adminservice.find(2);

		Assert.assertNull(admin4);
	}

	@Test
	void testCheckAdmin() {
		adminservice.checkAdmin("Ranjan", "@123");
		Assert.assertEquals(true, adminservice.checkAdmin("Ranjan", "@123"));
	}

}
