package com.luv2code.springsecurity.demo.config;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.*;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.*;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import com.luv2code.springsecurity.demo.service.UserService;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

	// add a reference to our security data source
    @Autowired
    private UserService userService;
	
    @Autowired
    private CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;
   
    @Autowired
    private CustomSessionInformationExpiredStrategy sessionInformationExpiredStrategy;
    
   @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.addFilterBefore(loginAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
        .exceptionHandling()
		.authenticationEntryPoint(loginUrlAuthenticationEntryPoint())
		.and()
		.authorizeRequests()
			.antMatchers("/showMyLoginPage","/randCode").permitAll() //可以直接访问
//            .anyRequest().authenticated()
//			.formLogin()
//				.loginPage("/showMyLoginPage")
//				.loginProcessingUrl("/authenticateTheUser")
//				.successHandler(customAuthenticationSuccessHandler)
//				.permitAll()
			.and()
			.logout().permitAll()
			.and()
			.exceptionHandling().accessDeniedPage("/access-denied");
		http.sessionManagement().maximumSessions(1)
		.expiredSessionStrategy(sessionInformationExpiredStrategy);		
		
		
	}
	
	//beans
	//bcrypt bean definition
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	//authenticationProvider bean definition
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
		auth.setUserDetailsService(userService); //set the custom user details service
		auth.setPasswordEncoder(passwordEncoder()); //set the password encoder - bcrypt
		return auth;
	}
	
	@Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }


    /*LoginAuthenticationFilter Bean*/
    @Bean
    public LoginAuthenticationFilter loginAuthenticationFilter() throws Exception {
        LoginAuthenticationFilter loginAuthenticationFilter=new LoginAuthenticationFilter();
        loginAuthenticationFilter.setAuthenticationManager(authenticationManagerBean());
        loginAuthenticationFilter.setFilterProcessesUrl("/authenticate");
        loginAuthenticationFilter.setAuthenticationSuccessHandler(customAuthenticationSuccessHandler);
        loginAuthenticationFilter.setAuthenticationFailureHandler(authenticationFailureHandler());
        return loginAuthenticationFilter;
    }

    /*endpoint Bean*/
    @Bean
    public LoginUrlAuthenticationEntryPoint loginUrlAuthenticationEntryPoint(){
        LoginUrlAuthenticationEntryPoint loginUrlAuthenticationEntryPoint=new LoginUrlAuthenticationEntryPoint("/showMyLoginPage");
        return loginUrlAuthenticationEntryPoint;
    }



    /* Bean*/
    @Bean
    public AuthenticationFailureHandler authenticationFailureHandler() {
        
        ExceptionMappingAuthenticationFailureHandler failureHandler = new ExceptionMappingAuthenticationFailureHandler();
        Map<String, String> failureUrlMap = new HashMap<>();
        failureUrlMap.put(BadCredentialsException.class.getName(), LoginAuthenticationFailureHandler.PASS_ERROR_URL);
        failureUrlMap.put(CaptchaException.class.getName(), LoginAuthenticationFailureHandler.CODE_ERROR_URL);
        failureUrlMap.put(AccountExpiredException.class.getName(), LoginAuthenticationFailureHandler.EXPIRED_URL);
        failureHandler.setExceptionMappings(failureUrlMap);
        return failureHandler;
    }


    /*Bean*/
    @Bean
    public DefaultKaptcha captchaProducer(){
        DefaultKaptcha captchaProducer =new DefaultKaptcha();
        Properties properties =new Properties();
        properties.setProperty("kaptcha.border","yes");
        properties.setProperty("kaptcha.border.color","105,179,90");
        properties.setProperty("kaptcha.textproducer.font.color","red");
        properties.setProperty("kaptcha.image.width","125");
        properties.setProperty("kaptcha.image.height","45");
        properties.setProperty("kaptcha.textproducer.font.size","45");
        properties.setProperty("kaptcha.session.key","code");
        properties.setProperty("kaptcha.textproducer.char.length","4");
        properties.setProperty("kaptcha.textproducer.font.names","宋体,楷体,微软雅黑");
        Config config=new Config(properties);
        captchaProducer.setConfig(config);
        return  captchaProducer;
    }
}	
	  







