package com.training;



import java.time.LocalDate;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.training.enities.Account;
import com.training.enities.Customer;
import com.training.enities.MyUser;
import com.training.repo.AccountRepo;
import com.training.repo.CustomerRepo;
import com.training.repo.UserRepo;
import com.training.uploadingfiles.storage.StorageProperties;
import com.training.uploadingfiles.storage.StorageService;



@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class SpringBootBankingProjectApplication {
@Autowired
	private AccountRepo accRepo;

@Autowired
private CustomerRepo custRepo;

@Autowired
private UserRepo userRepo;


	public static void main(String[] args) {
		SpringApplication.run(SpringBootBankingProjectApplication.class, args);
	}
	
	@Bean
	CommandLineRunner init(StorageService storageService) {
		return (args) -> {
			//storageService.deleteAll();
			//storageService.init();
		//	System.out.print(accRepo.getAccounts(LocalDate.parse("2020-02-03"),LocalDate.parse("	")));
			
			
		};
		
		
	}
	
	@Bean
	public CommandLineRunner getCommandLineRunner() {
	
		return (String args[])->{
			//System.out.println("Runner");
			
			/*
			 * List<Account> list = accRepo.findByCustomer(22); System.out.println(list);
			 * 
			 * Customer c= custRepo.findById(22l).get(); System.out.println(c);
			 */
			
			//custRepo.deleteById(85l);
			/*Account account1=new Account();
			
			 * 
			 * account1.setBalance(1000); account1.setDoa(LocalDate.now()); Account
			 * account2=new Account(); account2.setBalance(1000);
			 * account2.setDoa(LocalDate.now()); Customer customer = new Customer();
			 * customer.setName("sam"); LocalDate dob = LocalDate.parse("1988-04-05");
			 * customer.setDob(dob);
			 * 
			 * account1.setCustomer(customer); account1.setAccountType("SB");
			 * 
			 * account2.setCustomer(customer); account2.setAccountType("Current");
			 * 
			 * List<Account> accounts = Arrays.asList(account1,account2);
			 * 
			 * customer.setAccounts(accounts); custRepo.save(customer);
			 */
			
		};
		
		
	}

	public String getPassword(String password)
	{
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(password);
		

		return hashedPassword;
	}
	
	
	
	
	
	  @PostConstruct public void init() {
		  MyUser user1 = new MyUser("user2",getPassword("user123"),true,"ROLE_CUSTOMER");
			 userRepo.save(user1); 
			 MyUser user2 = new MyUser("admin2",getPassword("admin123"),true,"ROLE_ADMIN");
			 userRepo.save(user2); 
		  /*Account account1=new Account();
	  
	  
	 * account1.setBalance(1000); account1.setDoa(LocalDate.now()); Account
	 * account2=new Account(); account2.setBalance(1000);
	 * account2.setDoa(LocalDate.now()); Customer customer = new Customer();
	 * customer.setName("sam"); 
	 * LocalDate dob = LocalDate.parse("1988-04-05");
	 * customer.setDob(dob);
	 * 
	 * account1.setCustomer(customer); account1.setAccountType("SB");
	 * 
	 * account2.setCustomer(customer); account2.setAccountType("Current");
	 * 
	 * List<Account> accounts = Arrays.asList(account1,account2);
	 * 
	 * customer.setAccounts(accounts); custRepo.save(customer); MyUser user1 = new
	 * MyUser("user2",getPassword("user123"),true,"ROLE_CUSTOMER");
	 * userRepo.save(user1); MyUser user2 = new
	 * MyUser("admin2",getPassword("admin123"),true,"ROLE_ADMIN");
	 * userRepo.save(user2); 
	 */

	  }
	 
	 
	 
}
