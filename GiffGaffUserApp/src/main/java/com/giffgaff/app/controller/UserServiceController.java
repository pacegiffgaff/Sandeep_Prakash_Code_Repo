package com.giffgaff.app.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.giffgaff.app.model.MessageBean;
import com.giffgaff.app.model.User;
import com.giffgaff.app.service.UserService;

/**
 * User controller class is capture the request from json and send it to service
 * layer
 * 
 * @author Prakash/Sandeep
 *
 */
@RestController
public class UserServiceController {

	private static final Logger logger = Logger.getLogger(UserServiceController.class);

	@Autowired
	UserService userService;

	/**
	 * add user method is used to store user data into database
	 * 
	 * @param user
	 * @return
	 */
	@PostMapping("/adduser")
	@ResponseStatus(value = HttpStatus.CREATED)
	public ResponseEntity<String> addUser(@RequestBody User user) {
		User userObj = userService.addUser(user);
		logger.info("User data Saved Successfully" + userObj.getUserid() + " " + userObj.getUsername() + " "
				+ userObj.getRole() + " " + userObj.getDob());
		return new ResponseEntity<String>("User details are " + userObj.getUserid() + " " + userObj.getUsername() + " "
				+ userObj.getRole() + " " + userObj.getDob(), HttpStatus.CREATED);

	}

	/**
	 * This method is used to delete user data based on the id
	 * 
	 * @param id
	 * @return
	 */
	@DeleteMapping("/deleteuser/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity<String> deleteById(@PathVariable Long id) {
		userService.deleteById(id);
		logger.info("user data deleted for :" + id);
		return new ResponseEntity<String>("User details are " + id, HttpStatus.CREATED);
	}

	/**
	 * Get the user details from Database
	 * 
	 * @param userid
	 * @return
	 */
	@GetMapping("/getuser/{userid}")
	@ResponseStatus(value = HttpStatus.OK)
	public Optional<User> getUser(@PathVariable Long userid) {
		Optional<User> user;
		user = userService.getUserById(userid);
		logger.info("user data deleted for :" + user);
		return user;

	}
	
	@GetMapping("/getlist")
	public List<User> getListOfUsers(){
		
		List<User> listOfUsers = userService.getListOfUsers();
		for (User user : listOfUsers) {
			logger.info(user.getUserid()+""+user.getUsername()+""+user.getDob()+""+user.getRole());
			//return user;
		}
		
		return listOfUsers;
		
	}

	/**
	 * Update user date based on the user id
	 * 
	 * @param userid
	 * @param user
	 * @return
	 */
	@PutMapping("/updateuser/{userid}")
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity<String> updateUserById(@PathVariable("userid") Long userid, @RequestBody User user) {
		user.setUserid(userid);
		User userObj = userService.updateUserById(user);
		logger.info("updated user details are :" + userObj.getUserid() + " " + userObj.getUsername() + " " + userObj.getRole()
				+ " " + user.getDob());
		return new ResponseEntity<String>("User id :" + userObj.getUserid() + "Saved", HttpStatus.OK);

	}

	/**
	 * Handle Database error and send status
	 * 
	 * @return
	 */
	@ExceptionHandler({ SQLException.class, DataAccessException.class })
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "ERROR ON SERVER")
	public ResponseEntity<MessageBean> handleDatabaseError() {
		return new ResponseEntity<MessageBean>(new MessageBean("Database Error", "DBERR"),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
