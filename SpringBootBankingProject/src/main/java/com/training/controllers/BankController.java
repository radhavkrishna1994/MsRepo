package com.training.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.enities.AuthRequest;
import com.training.util.JwtUtil;

@RequestMapping("/bank")
@RestController
public class BankController {
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
    private AuthenticationManager authenticationManager;
	
	@PostMapping("/login")
    public String generateToken(@RequestBody AuthRequest authRequest) throws Exception { //from json input
		System.out.println("input :"+authRequest);
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
            );
        } catch (Exception ex) {
        	System.out.println("Exception:"+ex);
           // throw new Exception("invalid username/password");
            return "Invalid Username/Password";
        }
       
		return jwtUtil.generateToken(authRequest.getUsername());
    }
}
