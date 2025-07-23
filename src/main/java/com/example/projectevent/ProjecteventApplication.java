package com.example.projectevent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class ProjecteventApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjecteventApplication.class, args);
	}

}
