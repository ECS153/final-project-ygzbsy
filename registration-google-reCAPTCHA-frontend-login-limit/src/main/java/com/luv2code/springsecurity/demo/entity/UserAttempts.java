package com.luv2code.springsecurity.demo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "userattempts")
public class UserAttempts {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "attempts")
	private int attempts;
	
	@Column(name = "lastModified")
	private Date lastModified;
	
	// define constructor
	
	public UserAttempts() {
		
	}

	public UserAttempts(String username, int attempts, Date lastModified) {
		this.username = username;
		this.attempts = attempts;
		this.lastModified = lastModified;
	}

	//getter and setter
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getAttempts() {
		return attempts;
	}

	public void setAttempts(int attempts) {
		this.attempts = attempts;
	}

	public Date getLastModified() {
		return lastModified;
	}

	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}
	
	// define toString

	@Override
	public String toString() {
		return "UserAttempts [id=" + id + ", username=" + username + ", attempts=" + attempts + ", lastModified="
				+ lastModified + "]";
	}
	

	
	
	

}