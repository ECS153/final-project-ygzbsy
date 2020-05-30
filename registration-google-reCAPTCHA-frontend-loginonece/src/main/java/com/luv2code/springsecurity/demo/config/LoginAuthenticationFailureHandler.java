package com.luv2code.springsecurity.demo.config;


public class LoginAuthenticationFailureHandler {
    public static final String CODE_ERROR_URL = "http://localhost:8080/showMyLoginPage?code_error";
    public static final String EXPIRED_URL = "http://localhost:8080/showMyLoginPage?expired";

    public static final String PASS_ERROR_URL = "http://localhost:8080/showMyLoginPage?error";

    public LoginAuthenticationFailureHandler() {
    }


}