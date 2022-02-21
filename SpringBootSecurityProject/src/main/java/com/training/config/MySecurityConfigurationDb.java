package com.training.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class MySecurityConfigurationDb extends WebSecurityConfigurerAdapter{

	@Bean
	public PasswordEncoder getPassword()
	{
		BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
		return encoder;
		
	}
	
	//Authentication
	public void configure(AuthenticationManagerBuilder auth) throws Exception
	{
		auth
		.inMemoryAuthentication() // Default UserDetailsService
		.withUser("user1")
	//	.password("{noop}user1")
		.password(getPassword().encode("user1"))
		.roles("USER")
		.and()
		.withUser("admin")
		//.password("{noop}admin123")
		.password(getPassword().encode("admin123"))
		.roles("ADMIN");
		
	}
	
	//authorization
	public void configure(HttpSecurity http) throws Exception
	{
		http
		.authorizeRequests()
		.antMatchers("/admin/**")
		.hasRole("ADMIN")
		.antMatchers("/user/**")
		.hasAnyRole("USER","ADMIN")
		.anyRequest()
		.authenticated()
		.and()
		.formLogin()
		.loginPage("/login")
		.permitAll();
		
	}
	
	
}
