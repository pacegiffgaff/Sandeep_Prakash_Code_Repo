package com.giffgaff.app.main;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.giffgaff.app.model.User;
import com.giffgaff.app.service.UserService;

/**
 * CommandLineRunner
 * 
 * @author Prakash/Sandeep
 *
 */
public class UserCommandLineRunner implements CommandLineRunner {

	private static final Logger logger = Logger.getLogger(UserCommandLineRunner.class);

	@Autowired
	UserService userService;

	@Override
	public void run(String... args) throws Exception {

		logger.info("Add user data to user table");
		userService.addUser(new User("Prakash", "SSE", new Date()));
		userService.addUser(new User("Prakash", "SSE", new Date()));
		userService.addUser(new User("Sandeep", "SSA", new Date()));
		userService.addUser(new User("Raj", "SS", new Date()));
		userService.addUser(new User("Vipul", "SA", new Date()));
		userService.addUser(new User("Ramana", "SA", new Date()));

		logger.info("get list of users from database");
		List<User> userObj = userService.getListOfUsers();
		logger.info("Retrieve user data" + userObj);
		User user1 = new User();
		user1.setUserid(userObj.get(2).getUserid());
		user1.setUsername("Sandeep");
		user1.setRole("Engineer");
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		java.util.Date dob = sdf.parse("26-07-1987");
		user1.setDob(dob);
		logger.info("update user which is coming from database");
		userService.addUser(user1);

		logger.info("Delete user from database based on id");
		userService.deleteById(userObj.get(1).getUserid());

	}

}
