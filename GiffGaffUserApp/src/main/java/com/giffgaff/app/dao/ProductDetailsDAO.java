package com.giffgaff.app.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.giffgaff.app.model.Product;

@Repository
public interface ProductDetailsDAO extends CrudRepository<Product, Long> {

}
