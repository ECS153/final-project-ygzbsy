package com.luv2code.springsecurity.demo.config;

import org.springframework.http.HttpStatus;
import org.springframework.security.web.session.SessionInformationExpiredEvent;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Component
public class CustomSessionInformationExpiredStrategy implements SessionInformationExpiredStrategy{

	@Override
	public void onExpiredSessionDetected(SessionInformationExpiredEvent event) throws IOException, ServletException {
		 HttpServletResponse response = event.getResponse();
	        response.setStatus(HttpStatus.UNAUTHORIZED.value());
	        response.setContentType("application/json;charset=utf-8");
	        
	        response.sendRedirect("/showMyLoginPage?expired");
//	        getWriter().write("Your account has been logged in elsewhere, and the current login has been terminated. If the password is damaged, please change the password immediately!");
	}

}
