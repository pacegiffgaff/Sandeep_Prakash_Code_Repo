package com.giffgaff.ims.dao;

import com.giffgaff.ims.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDAO extends JpaRepository<Order,Long> {
}
