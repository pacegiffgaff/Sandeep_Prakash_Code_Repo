package com.giffgaff.ims.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.giffgaff.ims.model.Product;

@Repository
public interface InventoryMgmtServiceDAO extends CrudRepository<Product, Long> {

}
