package com.company.todo.springbootapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@ComponentScan({ "com.company.todo.springbootapp", "com.company.todo.controller", "com.company.todo.dao",
		"com.company.todo.impl","com.company.todo.model" })
@EnableMongoRepositories ("com.company.todo.dao")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}