package com.giffgaff.ims.service;

import com.giffgaff.ims.model.User;

public interface UserService {
	void save(User user);

	User findByUsername(String username);
}
