package com.giffgaff.ims.controller;

import com.giffgaff.ims.model.Inventory;
import com.giffgaff.ims.model.Product;
import com.giffgaff.ims.model.RawMaterial;
import com.giffgaff.ims.model.Stock;
import com.giffgaff.ims.service.ManufacturingMgmtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/rest")
public class ManufacturingMgmtRESTController {

    @Autowired
    ManufacturingMgmtService manufacturingMgmtService;

    public RawMaterial addRawMaterial(@RequestBody RawMaterial rawMaterial) {
        return manufacturingMgmtService.addRawMaterial(rawMaterial);
    }

    public Product addProduct(@RequestBody Product product){
        return manufacturingMgmtService.addProduct(product);
    }

    public Product getProduct() {
        return new Product();
    }

    public RawMaterial viewRawMaterials() {
        return new RawMaterial();
    }

    public List<RawMaterial> getRawMaterials(){
        return  manufacturingMgmtService.getRawMaterials();

    }

    public List<Product> getProducts(){
        return  manufacturingMgmtService.getProducts();
    }

    @PutMapping("/stocks/{lot}")
    public Integer manufactureAllProductsinLot(@PathVariable int lot){
        return manufacturingMgmtService.manufactureAllProductsinLot(lot);
    }

    @PutMapping("/stock/{lot}")
    public Stock manufactureAllProductInLot(@RequestBody Product product, @PathVariable Integer lot){
        return manufacturingMgmtService.manufactureProductInLot(product,lot);
    }

    @PutMapping("/rawmaterial/{id}")
    public RawMaterial updateRawMaterial(long id) {
        return null;
    }
    @GetMapping("/stocks")
    public List<Stock> getStockofAllProducts(){
        return  manufacturingMgmtService.getStockOfAllProducts();
    }

    @GetMapping("/inventory")
    public List<Inventory> getInventoryOfRawMaterials(){
        return  manufacturingMgmtService.getInventoryOfAllrawMaterials();
    }

}
