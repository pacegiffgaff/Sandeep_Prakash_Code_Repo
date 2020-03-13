package com.giffgaff.ims.service;

import com.giffgaff.ims.model.Inventory;
import com.giffgaff.ims.model.Product;
import com.giffgaff.ims.model.RawMaterial;
import com.giffgaff.ims.model.Stock;

import java.util.List;

public interface ManufacturingMgmtService {

    RawMaterial addRawMaterial(RawMaterial rawMaterial);

    List<RawMaterial> getRawMaterials();

    Product addProduct(Product product);

    List<Product> getProducts();

    Integer manufactureAllProductsinLot(Integer lot);

    Stock manufactureProductInLot(Product product, Integer lot);

    List<Stock> getStockOfAllProducts();

    List<Inventory> getInventoryOfAllrawMaterials();

    int manufactureProducts(int lot);
}
