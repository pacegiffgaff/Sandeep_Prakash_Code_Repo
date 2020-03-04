package com.giffgaff.app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.giffgaff.app.dao.ProductDetailsDAO;
import com.giffgaff.app.model.Product;
import com.giffgaff.app.service.ProductDetailsService;

@Component
public class ProductDetailsServiceImpl implements ProductDetailsService {

	@Autowired
	ProductDetailsDAO productDetailsDAO;

	@Override
	public void addProduct(Product product) {
		productDetailsDAO.save(product);
	}

	@Override
	public List<Product> getProductDetails() {
		List<Product> product;
		return product = (List<Product>) productDetailsDAO.findAll();

	}

	@Override
	public void deleteProductById(Long pid) {
		// TODO Auto-generated method stub
		productDetailsDAO.deleteById(pid);
	}

	@Override
	public void updateProductById(Product product) {
		// TODO Auto-generated method stub
		productDetailsDAO.save(product);
	}

	@Override
	public Optional<Product> getProductById(Long pid) {
		// TODO Auto-generated method stub
		Optional<Product> product;
		return product = productDetailsDAO.findById(pid);

	}
}
