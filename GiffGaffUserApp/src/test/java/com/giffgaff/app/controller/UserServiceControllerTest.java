package com.giffgaff.app.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import com.giffgaff.app.model.User;
import com.giffgaff.app.service.UserService;

/**
 * @author Sandeep/Prakash
 *
 */
@SuppressWarnings("deprecation")
@RunWith(MockitoJUnitRunner.class)
public class UserServiceControllerTest {

	@Mock
	UserService userServiceMock;

	@InjectMocks
	UserServiceController userServiceController;

	@Test
	public void testAddUser() {

		User user = new User();
		user.setUserid(65L);
		user.setUsername("Prakash");
		user.setRole("Analyst");
		when(userServiceMock.addUser(user)).thenReturn(user);
		ResponseEntity<String> response = userServiceController.addUser(user);
		assertEquals(201, response.getStatusCodeValue());

	}

	@Test
	public void testGetUserList() {

		List<User> userlist = new ArrayList<User>();
		User user = new User();
		user.setUserid(65L);
		user.setUsername("Prakash");
		user.setRole("Analyst");

		User user1 = new User();
		user1.setUserid(90L);
		user1.setUsername("Badisa");
		user1.setRole("Software");
		userlist.add(user);
		userlist.add(user1);

		when(userServiceMock.getListOfUsers()).thenReturn(userlist);

		List<User> listofusers = userServiceController.getListOfUsers();
		assertEquals(2, listofusers.size());

	}

	@Test
	public void testUpdateUserById() {
		User user = new User();
		user.setUserid(65L);
		user.setUsername("Prakash");
		user.setRole("Analyst");
		when(userServiceMock.updateUserById(user)).thenReturn(user);
		ResponseEntity<String> response = userServiceController.updateUserById(65L, user);
		assertEquals(200, response.getStatusCodeValue());

	}

}
