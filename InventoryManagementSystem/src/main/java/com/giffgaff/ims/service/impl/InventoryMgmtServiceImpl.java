package com.giffgaff.ims.service.impl;

import java.util.List;
import java.util.Optional;

import com.giffgaff.ims.dao.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.giffgaff.ims.dao.InventoryDAO;
import com.giffgaff.ims.model.Product;
import com.giffgaff.ims.service.InventoryMgmtService;

@Component
public class InventoryMgmtServiceImpl implements InventoryMgmtService {

	@Autowired
	ProductDAO productDAO;

	public void deleteById(Long id) {
		productDAO.deleteById(id);
	}

	@Override
	public Product addProduct(Product product) {
		Product prodObj = productDAO.save(product);
		return prodObj;
	}

	@Override
	public Optional<Product> getProductById(Long prodid) {
		Optional<Product> product;
		return product = productDAO.findById(prodid);
	}

	@Override
	public List<Product> getListOfProdcts() {
		List<Product> product;
		return product = (List<Product>) productDAO.findAll();
	}

	@Override
	public Product updateProductById(Product product) {
		Product prodObj = productDAO.save(product);
		// TODO Auto-generated method stub
		return prodObj;
	}
}
