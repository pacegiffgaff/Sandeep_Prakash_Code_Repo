package com.giffgaff.ims.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.giffgaff.ims.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
