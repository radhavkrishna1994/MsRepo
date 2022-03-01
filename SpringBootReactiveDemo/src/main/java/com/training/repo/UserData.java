package com.training.repo;

import java.time.Duration;
import java.util.List;
import java.util.stream.IntStream;

import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

import com.training.model.User;

import reactor.core.publisher.Flux;

@Component
// System.out::print
public class UserData {

	public List<User> getUsers()
	{
		return IntStream.rangeClosed(3, 10)
				.peek(UserData::sleepThread)
				.peek(i->System.out.println("Processing.."+i))
				.mapToObj(i->new User(i, "User:"+i, "user@gmail.com"))
				.collect(Collectors.toList());
	}
	
	private static void sleepThread(int i) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Flux<User> getUsersStream()
	{
		return Flux.range(3, 10)
				.delayElements(Duration.ofSeconds(1))
				.doOnNext(i->System.out.println("Processing.."+i))
				.map(i->new User(i, "User:"+i, "user@gmail.com"))
				.log();
	}
	
}
