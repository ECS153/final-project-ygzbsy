package com.luv2code.springsecurity.demo.config;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.google.code.kaptcha.Constants;

public class LoginAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private static  final Logger logger=Logger.getLogger(LoginAuthenticationFilter.class.getName());

    public LoginAuthenticationFilter() {
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {

        //获取表单提交的验证码的值
        String verification = request.getParameter("code");
        //获取下发的存在session中的验证码的值
        String captcha = (String) request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);

        if (captcha==null){
            throw new CaptchaException("Verification code can not be empty");
        }
        else  if (!captcha.contentEquals(verification)) {
            throw new CaptchaException("Verification cade does not match");
        }
        //调用UsernamePasswordAuthenticationFilter的认证方法
        return super.attemptAuthentication(request, response);
    }
}