package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Bidder {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private int bidderId;
	@NotNull(message="userName cannot be null")
	private String userName;
	
	@NotNull(message="password cannot be null")
	private String password;
	
	@NotNull(message="Name cannot be null")
	private String Name;

	@NotNull(message="email cannot be null")
	private String email;

	@NotNull(message="phoneNo cannot be null")
	private String phoneNo;
	
	public Bidder() {}

	public int getBidderId() {
		return bidderId;
	}

	public void setBidderId(int bidderId) {
		this.bidderId = bidderId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
}
