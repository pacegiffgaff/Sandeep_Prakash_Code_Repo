package com.giffgaff.ims.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

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

	public Product addProduct(Product product) {
		Product productObj = productDAO.save(product);
		logger.info("Product ID :" + productObj.getProductId() + "Product name" + productObj.getProductName()
				+ "description" + productObj.getDescription() + "Product Type" + productObj.getProductType()
				+ "Product Specifications" + productObj.getSpecifications());
		return productObj;
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
