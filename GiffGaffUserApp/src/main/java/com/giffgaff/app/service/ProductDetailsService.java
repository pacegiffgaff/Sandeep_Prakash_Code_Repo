package com.giffgaff.app.service;

import java.util.List;
import java.util.Optional;

import com.giffgaff.app.model.Product;

public interface ProductDetailsService {

	void addProduct(Product product);

	void deleteProductById(Long pid);

	List<Product> getProductDetails();
	
	Optional<Product> getProductById(Long pid);

	void updateProductById(Product product);

}
