package com.training.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.enities.Account;
import com.training.enities.Customer;
import com.training.repo.AccountRepo;
import com.training.repo.CustomerRepo;

@Service
public class CustomerService {
	
	@Autowired
	private AccountRepo accRepo;
	
	public List<Account> getAllAccounts(long custId)
	{
		List<Account> accounts = accRepo.findByCustomer(custId);
						
		return accounts;
	}
	
	public String withdraw(long accountNo,double amount)
	{
		Optional<Account> accountOp = accRepo.findById(accountNo);
		Account account =accountOp.get();
		double balance = account.getBalance();
			
		if(accountOp.isPresent() && account.getBalance() > amount - 1000)
		{
			account.setBalance(amount);
			accRepo.save(account);
			return "updated: Balance="+balance;
		}
		return "Not updated:"+balance;
			
	}

}
