package com.training.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.enities.Account;
import com.training.enities.AuthRequest;
import com.training.enities.Customer;
import com.training.services.CustomerService;
import com.training.util.JwtUtil;

@RequestMapping("/bank/customer")
@RestController
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/customer/hello")
	public String sayHelloUser()
	{
		return "Hello User";
	}
	
	@GetMapping("/getaccounts/custid/{custid}")
	public List<Account> getAllAccounts(@PathVariable("custid") long custId)
	{
		return customerService.getAllAccounts(custId);
	}
	
	
	
	
	
	
}
