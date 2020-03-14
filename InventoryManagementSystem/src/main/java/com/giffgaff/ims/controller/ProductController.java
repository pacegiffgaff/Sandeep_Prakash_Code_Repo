package com.giffgaff.ims.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.giffgaff.ims.model.Product;

@Controller
public class ProductController {

	@RequestMapping(value = "/product", method = RequestMethod.GET)
	public ModelAndView showForm() {
		return new ModelAndView("addProduct", "product", new Product());
	}
	
	@RequestMapping(value = "/addProduct", method = RequestMethod.POST)
    public String submit(@Valid @ModelAttribute("product")Product product, 
      BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }
        model.addAttribute("productName", product.getProductName());
        model.addAttribute("description", product.getDescription());
        model.addAttribute("productType", product.getProductType());
        model.addAttribute("specifications", product.getSpecifications());
        model.addAttribute("${productComponentList.quantity}", product.getProductComponentList().get(1).getQuantity());
        
        model.addAttribute("${productComponentList.rawMaterial.rawMaterialName}", product.getProductComponentList().get(1).getRawMaterial().getRawMaterialName());
        return "productView";
    }
}
