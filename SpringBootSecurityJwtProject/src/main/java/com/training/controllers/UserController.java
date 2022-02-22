package com.training.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.training.bean.Login;
import com.training.util.JwtUtil;

@CrossOrigin("/4200")
@RestController
public class UserController {

	@Autowired
	private AuthenticationManager authManagerBean;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@PostMapping("/authenticate")
	public String Authenticate(@RequestBody Login login) throws Exception
	{
		try {
		authManagerBean.authenticate(new UsernamePasswordAuthenticationToken
				(login.getUsername(),login.getPassword()));
		}
		catch(Exception ex)
		{
			System.out.println("Exception :"+ex);
			throw new Exception("Invalid Credentials..");
		}
		return jwtUtil.generateToken(login.getUsername());
	}
	
	@GetMapping({"/","/hello"})
	public String sayHello()
	{
		return "Hi ! Welcome to Spring Security";
	}
	
	@GetMapping({"/user/hello"})
	public String sayHelloUser()
	{
		return "Hi ! Welcome to Spring Security!! User";
	}
	
	@GetMapping({"/admin/hello"})
	public String sayHelloAdmin()
	{
		return "Hi ! Welcome to Spring Security!! Admin";
	}
}
