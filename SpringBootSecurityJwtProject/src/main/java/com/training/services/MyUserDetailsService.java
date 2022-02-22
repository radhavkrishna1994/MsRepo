package com.training.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.training.bean.MyUser;
import com.training.repo.UserRepo;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepo userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("Username Entered :"+username);
		
		Optional<MyUser> userOp = userRepo.findById(username);
		MyUser userFound=null;
		
		
		
		if(userOp.isPresent())
		{
			userFound = userOp.get();
			System.out.println("details fetched:"+userFound.getUsername()+" "+userFound.getPassword());
			/*
			 * String rolesArray[] = userFound.getRole().split(","); //
			 * [ROLE_USER,ROLE_ADMIN]
			 * 
			 * List<SimpleGrantedAuthority> listRoles = new ArrayList<>();
			 * 
			 * for(String role:rolesArray) listRoles.add(new SimpleGrantedAuthority(role));
			 */
			
		
			// Java 8
List<SimpleGrantedAuthority> listRoles = Arrays.stream(userFound.getRole().split(",")).map(SimpleGrantedAuthority::new).collect(Collectors.toList());
			
			return new User(username, userFound.getPassword(), listRoles);
		}
		return null;
	}
	
	

}
