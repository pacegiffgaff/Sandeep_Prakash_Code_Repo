package com.giffgaff.ims.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import com.giffgaff.ims.dao.ProductDAO;
import com.giffgaff.ims.model.Product;
import com.giffgaff.ims.service.ProductService;

@Component
public class ProductServiceImpl implements ProductService {

	private static final Logger logger = Logger.getLogger(ProductServiceImpl.class);

	@Autowired
	ProductDAO productDAO;

	public Product addProduct(Product product, Model model) {
		Product productObj = productDAO.save(product);
			logger.info("Product ID :" + productObj.getProductId() + "Product name" + productObj.getProductName()
					+ "description" + productObj.getDescription() + "Product Type" + productObj.getProductType()
					+ "Product Specifications" + productObj.getSpecifications());
		return productObj;
	}
}
