package com.giffgaff.app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.giffgaff.app.dao.UserServiceDAO;
import com.giffgaff.app.model.User;
import com.giffgaff.app.service.UserService;

/**
 * This is the implementation class for userService.
 * 
 * @author Sandeep/Prakash
 *
 */
@Component
public class UserServiceImpl implements UserService {

	@Autowired
	UserServiceDAO userServicedao;

	@Override
	public User addUser(User user) {
		User userObj = userServicedao.save(user);
		return userObj; 
	}

	@Override
	public List<User> getListOfUsers() {
		List<User> user;
		return user = (List<User>) userServicedao.findAll();

	}

	public void deleteById(Long id) {
		userServicedao.deleteById(id);
	}

	public Optional<User> getUserById(Long userid) {
		Optional<User> user;
		return user = userServicedao.findById(userid);

	}

	public User updateUserById(User user) {
		User userObj =userServicedao.save(user);
		return userObj;
	}

}
