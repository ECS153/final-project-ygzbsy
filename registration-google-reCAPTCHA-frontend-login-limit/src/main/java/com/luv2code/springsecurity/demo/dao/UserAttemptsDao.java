package com.luv2code.springsecurity.demo.dao;

import com.luv2code.springsecurity.demo.entity.UserAttempts;

public interface UserAttemptsDao {
	
	void updateFailAttempts(String username);
	void resetFailAttempts(String username);
	UserAttempts getUserAttempts(String username);

}
