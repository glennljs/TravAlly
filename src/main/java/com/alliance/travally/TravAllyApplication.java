package com.alliance.travally;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class TravAllyApplication {

	public static void main(String[] args) {
		SpringApplication.run(TravAllyApplication.class, args);
	}

}
