package com.training.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.training.filters.JwtFilter;
import com.training.services.MyUserDetailsService;

@Configuration
@EnableWebSecurity
public class MySecurityConfigurationDb extends WebSecurityConfigurerAdapter{

	@Autowired
	private MyUserDetailsService userDetailsService;
	
	//does not work for mysql
	/*
	 * @Bean public PasswordEncoder getPassword() { BCryptPasswordEncoder
	 * encoder=new BCryptPasswordEncoder(); return encoder;
	 * 
	 * }
	 */
	
	@Bean
	public PasswordEncoder getPassword()
	{
		PasswordEncoder encoder = new PasswordEncoder()
				{
					@Override
					public String encode(CharSequence rawPassword) {
						return rawPassword.toString();
					}

					@Override
					public boolean matches(CharSequence rawPassword, String encodedPassword) {
					
					return rawPassword.toString().equals(encodedPassword.toString());
						
					}
			
				};
		return encoder;
	}
	
	//Authentication
	public void configure(AuthenticationManagerBuilder auth) throws Exception
	{
		auth
		.userDetailsService(userDetailsService)
		.passwordEncoder(getPassword());
	}
	
	@Autowired
	private JwtFilter jwtFilter;
	
	//authorization
	public void configure(HttpSecurity http) throws Exception
	{
		http
		.csrf()
		.disable()
		.authorizeRequests()
		.antMatchers("/authenticate")
		.permitAll()
		.antMatchers("/admin/**")
		.hasRole("ADMIN")
		.antMatchers("/user/**")
		.hasAnyRole("USER","ADMIN")
		.anyRequest()
		.authenticated();
			
		http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
		
	}
	
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	
	
}
