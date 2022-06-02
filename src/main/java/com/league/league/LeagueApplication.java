package com.league.league;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LeagueApplication {

	static final Logger logger = LoggerFactory.getLogger(LeagueApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(LeagueApplication.class, args);
		logger.info("Application Fired Up and Running...");
	}

}
