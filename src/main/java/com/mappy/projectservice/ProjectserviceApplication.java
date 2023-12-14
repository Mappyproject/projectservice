package com.mappy.projectservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjectserviceApplication {
	public static void main(String[] args) {
		System.setProperty("application.properties", "project-service");
		SpringApplication.run(ProjectserviceApplication.class, args);
	}

}
