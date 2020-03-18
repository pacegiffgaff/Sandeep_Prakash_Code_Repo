package com.giffgaff.ims.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.giffgaff.ims.controller.form.ProductForm;
import com.giffgaff.ims.service.InventoryService;
import com.giffgaff.ims.service.ProductService;

@Controller
public class ProductController {

	private static final Logger logger = Logger.getLogger(ProductController.class);

	@Autowired
	ProductService productService;
	
	@Autowired
	InventoryService inventoryService;

	@RequestMapping(value = "/product", method = RequestMethod.GET)
	public String showForm(Model model) {

        List<String> rawMaterialList = inventoryService.getRawMaterialList();

		model.addAttribute("rawMaterialList", rawMaterialList);
		model.addAttribute("product", new ProductForm());
		return "jsp/addproduct";
	}

	/**
	 * Product information will be stored in Database
	 * 
	 * @param product
	 * @param model
	 * @return productView.jsp
	 */
	@RequestMapping(value = "/addproduct", method = RequestMethod.POST)
	public String addProduct(@ModelAttribute("product") ProductForm productForm, Model model) {
		logger.info("Product name" + productForm.getProductName() + "description" + productForm.getDescription()
				+ "Product Type" + productForm.getProductType() + "Product Specifications" + productForm.getSpecifications());
		model.addAttribute("productview", productService.addProduct(productForm));

		return "jsp/productview";
	}

	/**
	 * Display All product information
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/viewallproducts")
	public String viewAllProducts(Model model) {
		logger.info("Dispaly All Products");
		model.addAttribute("viewallproducts", productService.viewAllProducts());
		return "jsp/viewallproducts";
	}

	@RequestMapping("/productShopping")
	public String productShoppingView(Model model) {
		logger.info("Dispaly All Products");
		model.addAttribute("viewallproducts", productService.viewAllProducts());
		return "jsp/productShopping";
	}
}
