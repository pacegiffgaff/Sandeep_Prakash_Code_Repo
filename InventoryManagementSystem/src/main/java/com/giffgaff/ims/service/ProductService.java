package com.giffgaff.ims.service;

import org.springframework.ui.Model;

import com.giffgaff.ims.model.Product;

public interface ProductService {

	Product addProduct(Product product, Model model);
}
