package com.giffgaff.app.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Model class for userController 
 * @author Prakash/Sandeep
 *
 */
@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userid;
	private String username;
	private String role;
	private Date dob;

	public User() {

	}
	public User(Long userid, String username, String role, Date dob) {
		this.userid = userid;
		this.username = username;
		this.role = role;
		this.dob = dob;

	}

	public User(String username, String role, Date dob) {
		this.username = username;
		this.role = role;
		this.dob = dob;

	}

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "User [userid=" + userid + ", username=" + username + ", role=" + role + ", dob=" + dob + "]";
	}
}
