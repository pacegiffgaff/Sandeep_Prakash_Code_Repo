package com.giffgaff.ims.service;

import com.giffgaff.ims.model.Inventory;
import com.giffgaff.ims.model.Product;
import com.giffgaff.ims.model.RawMaterial;

import java.util.List;

public interface ManufacturingMgmtService {

    RawMaterial addRawMaterial(RawMaterial rawMaterial);

    List<RawMaterial> getRawMaterials();

    Product addProduct(Product product);

    List<Product> getProducts();
}
