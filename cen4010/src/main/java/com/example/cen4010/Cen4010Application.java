package com.example.cen4010;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController

public class Cen4010Application {

	public static void main(String[] args) {
		SpringApplication.run(Cen4010Application.class, args);
	}

	@GetMapping
	public java.lang.String hello() {
		return "Team 4";
	}

}
