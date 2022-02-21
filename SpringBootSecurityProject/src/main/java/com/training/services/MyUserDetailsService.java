package com.training.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.training.bean.MyUser;
import com.training.repo.UserRepo;
import org.springframework.security.core.userdetails.User;

//@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepo userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<MyUser> userOp = userRepo.findById(username);
		MyUser userFound=null;
		
		if(userOp.isPresent())
		{
			userFound = userOp.get();
			userFound.getRole(); // [ROLE_USER,ROLE_ADMIN]
			return new User(username, userFound.getPassword(), null);
		}
		return null;
	}
	
	

}
