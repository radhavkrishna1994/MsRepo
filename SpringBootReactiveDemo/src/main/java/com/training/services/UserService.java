package com.training.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.model.User;
import com.training.repo.UserData;

import reactor.core.publisher.Flux;

@Service
public class UserService {

	@Autowired
	private UserData userData;
	
	public List<User> getUsers() {
		long start = System.currentTimeMillis();
		List<User> usersList = userData.getUsers();
		long end = System.currentTimeMillis();
		System.out.println("Time Taken:"+(end-start));
		return usersList;
	}
	
	public Flux<User> getUsersStream()
	{
		long start = System.currentTimeMillis();
		Flux<User> userStream = userData.getUsersStream();
		long end = System.currentTimeMillis();
		System.out.println("Time Taken:"+(end-start));
		return userStream;
	}

}
