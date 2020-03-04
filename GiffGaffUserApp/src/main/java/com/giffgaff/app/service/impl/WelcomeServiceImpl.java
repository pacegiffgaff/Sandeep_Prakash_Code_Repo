package com.giffgaff.app.service.impl;

import org.springframework.stereotype.Component;

import com.giffgaff.app.service.WelcomeService;

@Component
public class WelcomeServiceImpl implements WelcomeService {

	public String getWelcomeMessage() {
		return "welcome message from service class and added spring boot parent \n" + "Refactored class names";
	}
}
