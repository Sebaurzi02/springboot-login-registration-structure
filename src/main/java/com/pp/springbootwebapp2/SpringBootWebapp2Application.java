package com.pp.springbootwebapp2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class SpringBootWebapp2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWebapp2Application.class, args);
	}

}
