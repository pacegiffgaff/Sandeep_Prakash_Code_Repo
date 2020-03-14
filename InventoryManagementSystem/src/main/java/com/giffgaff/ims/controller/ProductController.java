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
		return new ModelAndView("addProduct", "product", new Product());
	}

	@RequestMapping(value = "/addProduct", method = RequestMethod.POST)
	public String addProduct(@Valid @ModelAttribute("product") Product product, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "error";
		}
//        model.addAttribute("productName", product.getProductName());
//        model.addAttribute("description", product.getDescription());
//        model.addAttribute("productType", product.getProductType());
//        model.addAttribute("specifications", product.getSpecifications());
//        
		logger.info("Product name" + product.getProductName() + "description" + product.getDescription()
				+ "Product Type" + product.getProductType() + "Product Specifications" + product.getSpecifications());
		model.addAttribute("productView",productService.addProduct(product, model));

		return "productView";
	}
}
