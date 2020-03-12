package com.giffgaff.ims.controller;

import com.giffgaff.ims.model.Inventory;
import com.giffgaff.ims.model.Product;
import com.giffgaff.ims.model.RawMaterial;
import com.giffgaff.ims.service.ManufacturingMgmtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
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

    @GetMapping("/rawmaterials")
    public List<RawMaterial> getRawMaterials(){
       return  manufacturingMgmtService.getRawMaterials();

    }

    @GetMapping("/products")
    public List<Product> getProducts(){
        return  manufacturingMgmtService.getProducts();
    }

    @PostMapping
    public 

    @PutMapping("/rawmaterial/{id}")
    public RawMaterial updateRawMaterial(long id) {
        return null;
    }



}
