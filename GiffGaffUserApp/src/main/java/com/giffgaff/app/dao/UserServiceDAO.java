package com.giffgaff.app.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.giffgaff.app.model.User;

/**
 * This interface extends crudRepository interface for generic CRUD operations
 * on a repository for a specific type.
 * 
 * @author Prakash/Sandeep
 *
 */
@Repository
public interface UserServiceDAO extends CrudRepository<User, Long> {

}
