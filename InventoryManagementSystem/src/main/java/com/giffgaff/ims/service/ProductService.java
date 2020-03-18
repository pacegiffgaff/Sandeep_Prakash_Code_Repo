package com.giffgaff.ims.service;

import java.util.List;

import com.giffgaff.ims.controller.form.ProductForm;
import com.giffgaff.ims.model.Product;
import com.giffgaff.ims.model.RawMaterial;

public interface ProductService {

	Product addProduct(ProductForm productForm);

	List<Product> viewAllProducts();

	Product findProductByProductName(String productName);

	 List<String> getAllproductNames();

	List<RawMaterial> getRawmaterialList();

	}
