package com.project.todo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TodoApplication {

	public static void main(String[] args) {
		System.out.println("Server is running");
		SpringApplication.run(TodoApplication.class, args);
	}

}
