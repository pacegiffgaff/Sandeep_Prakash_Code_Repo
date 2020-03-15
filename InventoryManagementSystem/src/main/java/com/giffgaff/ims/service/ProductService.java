package com.giffgaff.ims.service;

import java.util.List;

import com.giffgaff.ims.model.Product;

public interface ProductService {

	Product addProduct(Product product);

	List<Product> viewAllProducts();
}
