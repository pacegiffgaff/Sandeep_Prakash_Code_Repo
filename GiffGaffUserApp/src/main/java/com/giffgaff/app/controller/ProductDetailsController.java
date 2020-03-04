package com.giffgaff.app.controller;

import java.sql.SQLException;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.giffgaff.app.model.MessageBean;
import com.giffgaff.app.model.Product;
import com.giffgaff.app.service.ProductDetailsService;

@RestController
public class ProductDetailsController {

	@Autowired
	ProductDetailsService productDetailsService;

	@PostMapping("/addProduct")
	@ResponseStatus(value = HttpStatus.CREATED)
	public ResponseEntity<String> addproduct(@RequestBody Product product) {
		productDetailsService.addProduct(product);
		return new ResponseEntity<String>("product details are " + product.getPid(), HttpStatus.CREATED);
	}

	@DeleteMapping("/deleteproductbyid/{pid}")
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity<String> deleteProductById(@PathVariable Long pid) {
		productDetailsService.deleteProductById(pid);
		return new ResponseEntity<String>("Product details are " + pid, HttpStatus.CREATED);
	}

	@GetMapping("/getproductbyid/{pid}")
	@ResponseStatus(value = HttpStatus.OK)
	public Optional<Product> getProductDetails(@PathVariable Long pid) {
		Optional<Product> product;
		return product = productDetailsService.getProductById(pid);

	}

	@PutMapping("/updateproductbyid")
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity<String> updateProductById(@RequestParam Product product) {
		productDetailsService.updateProductById(product);
		return new ResponseEntity<String>("User details are " + product.getPid(), HttpStatus.OK);
	}
	
	@ExceptionHandler({ SQLException.class, DataAccessException.class })
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "ERROR ON SERVER")
	public ResponseEntity<MessageBean> handleDatabaseError() {
		return new ResponseEntity<MessageBean>(new MessageBean("Database Error", "DBERR"),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}


}
