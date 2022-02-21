package com.training.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.enities.Account;
import com.training.enities.Customer;
import com.training.repo.AccountRepo;
import com.training.services.AdminService;

@RequestMapping("/bank/admin")
@RestController
public class AdminController {
	@Autowired
	private AdminService adminService;
	
	@GetMapping("/hello")
	public String sayHelloAdmin()
	{
		return "Hello Admin";
	}
	
	@PostMapping("/createcustomer")
	public Customer createCustomer(@RequestBody Customer customer)
	{
		return adminService.createCustomer(customer);
	}
	
	
	@PostMapping("/createaccount/{custid}")
	public Account createAccount(@RequestBody Account account,@PathVariable("custid") long custId)
	{
		return adminService.createAccount(account,custId);
	}
	
	@GetMapping("/deleteaccount/{accountno}")
	public boolean deleteAccount(@PathVariable("accountno") long accountno)
	{
		return adminService.deleteAccount(accountno);
	}
	
	@Autowired
	private AccountRepo accRepo;
	@GetMapping("/getaccounts/{startdate}/{enddate}")
	public List<Account> getAccounts(@PathVariable("startdate") String startdate,@PathVariable("enddate") String enddate)
	{
		LocalDate d1=LocalDate.parse(startdate);
		LocalDate d2=LocalDate.parse(enddate);
		
		System.out.println("Here...");
		return accRepo.getAccounts(d1, d2);
	}

}
