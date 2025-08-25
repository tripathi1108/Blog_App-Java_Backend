package com.example.TODO_BACKEND;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import  org.modelmapper.ModelMapper;
@SpringBootApplication
public class TodoBackendApplication {

	public static void main(String[] args) {

		SpringApplication.run(TodoBackendApplication.class, args);
	}

	@Bean
	public ModelMapper modalMapper(){
		return new ModelMapper();
	}
}
