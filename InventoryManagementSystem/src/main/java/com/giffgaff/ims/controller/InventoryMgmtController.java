package com.giffgaff.ims.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.giffgaff.ims.model.MessageBean;
import com.giffgaff.ims.model.Product;
import com.giffgaff.ims.service.InventoryMgmtService;

@RestController
public class InventoryMgmtController {

	private static final Logger logger = Logger.getLogger(InventoryMgmtController.class);

	@Autowired
	InventoryMgmtService inventoryMgmtService;

	/**
	 * add product method is used to store product data into database
	 * 
	 * @param product
	 * @return
	 */
	@PostMapping("/products")
	@ResponseStatus(value = HttpStatus.CREATED)
	public ResponseEntity<String> addProduct(@RequestBody Product product) {
		Product prodObj = inventoryMgmtService.addProduct(product);
		logger.info("products data Saved Successfully" + prodObj.getProdId() + " " + prodObj.getProdName() + " "
				+ prodObj.getDescription() + " " + prodObj.getProdType());
		return new ResponseEntity<String>("Product details are " + prodObj.getProdId() + " " + prodObj.getProdName()
				+ " " + prodObj.getDescription() + " " + prodObj.getProdType(), HttpStatus.CREATED);

	}

	/**
	 * This method is used to delete product data based on the id
	 * 
	 * @param id
	 * @return
	 */
	@DeleteMapping("/product/{prodid}")
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity<String> deleteById(@PathVariable Long prodid) {
		inventoryMgmtService.deleteById(prodid);
		logger.info("product data deleted for :" + prodid);
		return new ResponseEntity<String>("product details are " + prodid, HttpStatus.CREATED);
	}

	/**
	 * Get the product details from Database
	 * 
	 * @param prodid
	 * @return
	 */
	@GetMapping("/product/{prodid}")
	@ResponseStatus(value = HttpStatus.OK)
	public Optional<Product> getUser(@PathVariable Long prodid) {
		Optional<Product> product;
		product = inventoryMgmtService.getProductById(prodid);
		logger.info("user data deleted for :" + product);
		return product;

	}

	@GetMapping("/productList")
	public List<Product> getListOfProducts() {

		List<Product> listOfProducts = inventoryMgmtService.getListOfProdcts();
		for (Product product : listOfProducts) {
			logger.info(product.getProdId() + " " + product.getProdName() + " " + product.getDescription() + " "
					+ product.getProdType());
			// return user;
		}

		return listOfProducts;

	}

	/**
	 * Update product date based on the product id
	 * 
	 * @param prodid
	 * @param Product
	 * @return
	 */
	@PutMapping("/updateProduct/{prodid}")
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity<String> updateProductById(@PathVariable("prodid") Long prodid, @RequestBody Product product) {
		product.setProdId(prodid);
		Product prodObj = inventoryMgmtService.updateProductById(product);
		logger.info("updated product details are :" + prodObj.getProdId() + " " + prodObj.getProdName() + " "
				+ prodObj.getDescription() + " " + prodObj.getProdType());
		// return user;
		return new ResponseEntity<String>("{Product id :" + prodObj.getProdId() + "Saved", HttpStatus.OK);

	}

	/**
	 * Handle Database error and send status
	 * 
	 * @return
	 */
	@ExceptionHandler({ SQLException.class, DataAccessException.class })
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "ERROR ON SERVER")
	public ResponseEntity<MessageBean> handleDatabaseError() {
		return new ResponseEntity<MessageBean>(new MessageBean("Database Error", "DBERR"),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
