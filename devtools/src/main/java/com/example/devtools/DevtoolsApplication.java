package com.example.devtools;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DevtoolsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DevtoolsApplication.class, args);
	}
	@GetMapping("/")
	public String index(){
		return "Hello my name is quan";
	}
}
