package com.giffgaff.ims.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.giffgaff.ims.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByUsername(String username);
}
