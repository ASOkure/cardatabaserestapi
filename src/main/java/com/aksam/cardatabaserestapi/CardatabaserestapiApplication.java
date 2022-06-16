package com.aksam.cardatabaserestapi;

import com.aksam.cardatabaserestapi.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CardatabaserestapiApplication {

	@Autowired
	private CarRepository repository;
	@Autowired
	private OwnerRepository ownerRepository;

@Autowired
private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(CardatabaserestapiApplication.class, args);
	}

	@Bean
	CommandLineRunner runner() {
		return args -> {
// Add owner objects and save these to db
			Owner owner1 = new Owner("John" , "Johnson");
			Owner owner2 = new Owner("Mary" , "Robinson");
			ownerRepository.save(owner1);
			ownerRepository.save(owner2);
// Add car object with link to owners and save these to db.
			Car car = new Car("Ford", "Mustang", "Red",
					"ADF-1121", 2017, 59000, owner1);
			repository.save(car);
			car = new Car("Nissan", "Leaf", "White",
					"SSJ-3002", 2014, 29000, owner2);
			repository.save(car);
			car = new Car("Toyota", "Prius", "Silver",
					"KKO-0212", 2018, 39000, owner2);
			repository.save(car);

			// username: user password: user
			userRepository.save(new User("user",
					"$2a$10$ohVsm2VSY45m9pr/37u5fuksKFXFl0wU4WnaHr6OV.m8zxdiASyRK",
					"USER"));
// username: admin password: admin
			userRepository.save(new User("admin",
					"$2a$10$r1W5dEREG84IN/XLkb9lJuJn.jbCGVahW4WVqT0hj9z23V.BfhlFi",
					"ADMIN"));

		};

	}
}