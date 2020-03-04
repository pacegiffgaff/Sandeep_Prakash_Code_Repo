package com.giffgaff.app.main;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.giffgaff.app.controller.UserServiceController;

/**
 * Main class which is used to initialize spring boot application
 * 
 * @author Prakash/Sandeep
 *
 */
@SpringBootApplication
@ComponentScan("com.giffgaff.app")
@EntityScan("com.giffgaff.app.model")
@EnableJpaRepositories("com.giffgaff.app.dao")
public class GiffGaffUserApp {

	private static Logger logger = Logger.getLogger(GiffGaffUserApp.class);

	public static void main(String[] args) {
		logger.info("Giffgaff userapp application");
		SpringApplication.run(GiffGaffUserApp.class, args);

		logger.info("Application started successfully");
	}

}
