package com.giffgaff.ims.dao;

import com.giffgaff.ims.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductDAO extends CrudRepository<Product,Long> {
}
