package com.giffgaff.ims.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.giffgaff.ims.dao.InventoryMgmtServiceDAO;
import com.giffgaff.ims.model.Product;
import com.giffgaff.ims.service.InventoryMgmtService;

@Component
public class InventoryMgmtServiceImpl implements InventoryMgmtService {

	@Autowired
	InventoryMgmtServiceDAO inventoryMgmtServiceDAO;

	public void deleteById(Long id) {
		inventoryMgmtServiceDAO.deleteById(id);
	}

	@Override
	public Product addProduct(Product product) {
		Product prodObj = inventoryMgmtServiceDAO.save(product);
		return prodObj;
	}

	@Override
	public Optional<Product> getProductById(Long prodid) {
		Optional<Product> product;
		return product = inventoryMgmtServiceDAO.findById(prodid);
	}

	@Override
	public List<Product> getListOfProdcts() {
		List<Product> product;
		return product = (List<Product>) inventoryMgmtServiceDAO.findAll();
	}

	@Override
	public Product updateProductById(Product product) {
		Product prodObj = inventoryMgmtServiceDAO.save(product);
		// TODO Auto-generated method stub
		return prodObj;
	}
}
