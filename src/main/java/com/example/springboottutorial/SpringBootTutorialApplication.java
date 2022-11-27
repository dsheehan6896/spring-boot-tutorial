package com.example.springboottutorial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringBootTutorialApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootTutorialApplication.class, args);
	}

	//http://localhost:8080/hello
	@GetMapping("/hello")
	public String sayHello(@RequestParam(value = "myName", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}

	//http://localhost:8080/times
	//http://localhost:8080/times?myNumber=<int>
	@GetMapping("/times")
	public String multiplyByTwo(@RequestParam(value = "myNumber", defaultValue = "Please enter a number to multiply by 2 as a parameter...") String number) {
		try {
			int tempInt = Integer.valueOf(number.trim());
			number = String.valueOf(tempInt*2);
			return String.format("Heyo %s!", number);
		} catch (NumberFormatException ex) {
			return "Please enter a number to multiply by 2 as a parameter...";
		}
	}
}
