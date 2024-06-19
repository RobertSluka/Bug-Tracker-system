package com.example.demo;

import Bug.User;
import Bug.Repository.DeveloperRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BugTrackerSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(BugTrackerSystemApplication.class, args);


		DeveloperRepository repository = new DeveloperRepository();
		User marek = new User("developer","Mark", "123456789","Marek","Strucka","m@x.dk",1999);
		repository.save(marek);

		System.out.println(marek);

	}
}
