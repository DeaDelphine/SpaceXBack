package com.spaceX.spaceX;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpaceXApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpaceXApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {

	}
}
