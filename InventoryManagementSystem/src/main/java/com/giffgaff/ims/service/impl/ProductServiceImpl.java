package com.giffgaff.ims.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import com.giffgaff.ims.controller.form.ProductForm;
import com.giffgaff.ims.dao.ProductDAO;
import com.giffgaff.ims.dao.RawMaterialDAO;
import com.giffgaff.ims.model.Product;
import com.giffgaff.ims.model.RawMaterial;
import com.giffgaff.ims.service.ProductService;

@Component
public class ProductServiceImpl implements ProductService {

	private static final Logger logger = Logger.getLogger(ProductServiceImpl.class);

	@Autowired
	ProductDAO productDAO;

	@Autowired
	RawMaterialDAO rawMaterialDAO;

	public Product addProduct(ProductForm productForm) {
		
		List<String> rawmaterlnames= new ArrayList<String>();
				Arrays.stream(productForm.getComponents()).forEach(component->rawmaterlnames.add(component));
				List<RawMaterial> rawMaterials = rawMaterialDAO.findRawmaterialsByNameList(rawmaterlnames);
				
		Product product = new Product();
		product.setDescription(productForm.getDescription());
		product.setProductName(productForm.getProductName());
		product.setProductType(productForm.getProductType());
		product.setSpecifications(productForm.getSpecifications());
		product.setRawMaterialList(rawMaterials);
		product = productDAO.save(product);
		
		logger.info("Product ID :" + product.getProductId() + "Product name" + product.getProductName()
				+ "description" + product.getDescription() + "Product Type" + product.getProductType()
				+ "Product Specifications" + product.getSpecifications());
		return product;
	}

	@Override
	public List<Product> viewAllProducts() {
		List<Product> productList = productDAO.findAll();
		for (Product productObj : productList) {
			logger.info("Product ID :" + productObj.getProductId() + "Product name" + productObj.getProductName()
					+ "description" + productObj.getDescription() + "Product Type" + productObj.getProductType()
					+ "Product Specifications" + productObj.getSpecifications());
		}

		return productList;
	}

	@Override
	public Product findProductByProductName(String productName) {
		return productDAO.findByProductName(productName);
	}

	@Override
	public List<String> getAllproductNames() {
		List<String> productNames = new ArrayList<>();
		productDAO.findAll().forEach(product -> productNames.add(product.getProductName()));
		return productNames;
	}

	@Override
	public List<RawMaterial> getRawmaterialList() {
		List<RawMaterial> rawMaterialList = rawMaterialDAO.findAll();
		
		return rawMaterialList;
	}
}
