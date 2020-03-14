package com.giffgaff.ims.controller;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.giffgaff.ims.model.Product;
import com.giffgaff.ims.service.ProductService;

@Controller
public class ProductController {

	private static final Logger logger = Logger.getLogger(ProductController.class);

	@Autowired
	ProductService productService;

	@RequestMapping(value = "/product", method = RequestMethod.GET)
	public ModelAndView showForm() {
		return new ModelAndView("addproduct", "product", new Product());
	}

	/**
	 * Product information will be stored in Database
	 * 
	 * @param product
	 * @param result
	 * @param model
	 * @return productView.jsp
	 */
	@RequestMapping(value = "/addproduct", method = RequestMethod.POST)
	public String addProduct(@ModelAttribute("product") Product product, Model model) {
		logger.info("Product name" + product.getProductName() + "description" + product.getDescription()
				+ "Product Type" + product.getProductType() + "Product Specifications" + product.getSpecifications());
		model.addAttribute("productview", productService.addProduct(product));

		return "productview";
	}

	/**
	 * Display All product information
	 * @param model
	 * @return
	 */
	@RequestMapping("/viewallproducts")
	public String viewAllProducts(Model model) {
		logger.info("Dispaly All Products");
		model.addAttribute("viewallproducts", productService.viewAllProducts());
		return "viewallproducts";
	}
}
