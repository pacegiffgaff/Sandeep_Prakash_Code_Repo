package com.giffgaff.app.service;

import java.util.List;
import java.util.Optional;

import com.giffgaff.app.model.User;

/**
 * UserService Interface
 * @author ntttech04
 *
 */
public interface UserService {

	User addUser(User user);

	List<User> getListOfUsers();

	void deleteById(Long id);
	
	Optional<User> getUserById(Long userid);
	
	User updateUserById(User user);

}
