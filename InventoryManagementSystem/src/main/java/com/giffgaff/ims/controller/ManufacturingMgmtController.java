package com.giffgaff.ims.controller;

import com.giffgaff.ims.model.Product;
import com.giffgaff.ims.model.RawMaterial;
import com.giffgaff.ims.service.ManufacturingMgmtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ManufacturingMgmtController {

    @Autowired
    ManufacturingMgmtService manufacturingMgmtService;

    @PostMapping("/rawmaterial")
    public RawMaterial addRawMaterial(@RequestBody RawMaterial rawMaterial) {
         return manufacturingMgmtService.addRawMaterial(rawMaterial);
    }

    @PostMapping("/product")
    public Product addProduct(@RequestBody Product product){
        return manufacturingMgmtService.addProduct(product);
    }

    @GetMapping("/product")
    public Product getProduct() {
        return new Product();
    }

    @GetMapping("/rawmaterial")
    public RawMaterial viewRawMaterials() {
        return new RawMaterial();
    }

	@RequestMapping("/rawmaterials")
	public String getRawMaterials(Model model) {
		model.addAttribute("rawmaterials", manufacturingMgmtService.getProducts());

		return "rawmaterials";
	}

	@RequestMapping("/products")
	public String getProducts(Model model) {

		model.addAttribute("products", manufacturingMgmtService.getProducts());

		return "products";
	}


    @PutMapping("/rawmaterial/{id}")
    public RawMaterial updateRawMaterial(long id) {
        return null;
    }



}
