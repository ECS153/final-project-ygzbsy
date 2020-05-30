package com.luv2code.springsecurity.demo.config;

import org.springframework.security.authentication.AuthenticationServiceException;


public class CaptchaException extends AuthenticationServiceException {
    public CaptchaException(String msg) {
        super(msg);
    }
}