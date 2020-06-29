package com.app.toDoApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ToDoAppApplication {

	public static int reqUserId;
	public static String reqUser;

	public static void main(String[] args) {
		SpringApplication.run(ToDoAppApplication.class, args);
	}

}
