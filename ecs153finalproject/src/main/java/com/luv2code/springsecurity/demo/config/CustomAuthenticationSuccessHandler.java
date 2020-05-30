package com.luv2code.springsecurity.demo.config;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.luv2code.springsecurity.demo.dao.AttemptDao;
import com.luv2code.springsecurity.demo.dao.AttemptDaoImpl;
import com.luv2code.springsecurity.demo.dao.UserDao;
import com.luv2code.springsecurity.demo.entity.Attempts;
import com.luv2code.springsecurity.demo.entity.User;
import com.luv2code.springsecurity.demo.service.UserService;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    private UserService userService;
    
    @Autowired
	private AttemptDao attemptdao;
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {

		System.out.println("\n\nIn customAuthenticationSuccessHandler\n\n");

		String userName = authentication.getName();
		
		System.out.println("userName=" + userName);

		User theUser = userService.findByUserName(userName);
		
		
		//update attempts to 0
		Attempts attempt = new Attempts();
		
		attempt.setAttempts(0);
		attempt.setUsername(theUser.getUserName());
		attempt.setLastModified(new Date());
		
		System.out.println("cccccccccc");
		System.out.println("attempt=" + attempt);
		System.out.println("attempt=" + attempt.getLastModified());
		//attemptdao.save(attempt);
		
		// now place in the session
		HttpSession session = request.getSession();
		session.setAttribute("user", theUser);
		
		// forward to home page
		
		response.sendRedirect(request.getContextPath() + "/");
	}

}
