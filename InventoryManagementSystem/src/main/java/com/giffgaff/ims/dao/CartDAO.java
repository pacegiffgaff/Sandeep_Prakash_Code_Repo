package com.giffgaff.ims.dao;

import com.giffgaff.ims.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;

@Repository
public interface CartDAO extends JpaRepository<Cart,Long> {
    public Cart findByUser_Username(String userName);

    //@Query("select count ")

}
