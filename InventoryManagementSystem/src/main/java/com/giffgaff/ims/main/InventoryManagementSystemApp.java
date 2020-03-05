package com.giffgaff.ims.main;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.giffgaff.ims")
@EnableJpaRepositories("com.giffgaff.ims.dao")
@EntityScan("com.giffgaff.ims.model")
public class InventoryManagementSystemApp {

	private static final Logger logger = Logger.getLogger(InventoryManagementSystemApp.class);

	public static void main(String[] args) {
		SpringApplication.run(InventoryManagementSystemApp.class, args);
		logger.info("InventoryManagementSystemApp class Started");

	}

}
