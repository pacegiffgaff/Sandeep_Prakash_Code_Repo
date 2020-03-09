package com.giffgaff.ims.service;

import java.util.List;
import java.util.Optional;

import com.giffgaff.ims.model.Product;

public interface InventoryMgmtService {

	Product addProduct(Product product);

	void deleteById(Long prodid);

	Optional<Product> getProductById(Long prodid);

	List<Product> getListOfProdcts();

	Product updateProductById(Product product);

}
