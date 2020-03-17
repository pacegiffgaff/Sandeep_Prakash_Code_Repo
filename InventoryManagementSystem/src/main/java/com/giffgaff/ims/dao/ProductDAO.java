package com.giffgaff.ims.dao;

import com.giffgaff.ims.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDAO extends JpaRepository<Product,Long> {
    Product findByProductName(String productName);
}
