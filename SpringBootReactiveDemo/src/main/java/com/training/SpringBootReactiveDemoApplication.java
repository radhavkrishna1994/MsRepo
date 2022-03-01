package com.training;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.training.model.User;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@SpringBootApplication
public class SpringBootReactiveDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootReactiveDemoApplication.class, args);
	}

	@Bean
	CommandLineRunner getCommandLineRunner(ApplicationContext ctx)
	{
		return args->{
			
			Flux<Integer> integers = Flux.just(2,3,4,9);
			integers.doOnNext(i->System.out.print(i+" ")).subscribe();
			
			Mono<User> user = Mono.just(new User(1,"sam","sam@gmail.com"));
			user.subscribe(u->System.out.println(u));
			
			
		};
	}
}
