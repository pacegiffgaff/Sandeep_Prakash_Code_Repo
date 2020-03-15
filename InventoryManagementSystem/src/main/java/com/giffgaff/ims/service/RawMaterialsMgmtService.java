package com.giffgaff.ims.service;

import java.util.List;

import com.giffgaff.ims.model.Inventory;
import com.giffgaff.ims.model.Product;
import com.giffgaff.ims.model.RawMaterial;

public interface RawMaterialsMgmtService {

	List<Product> getRawMaterialsWithSpecs();

	List<Inventory> trackRawmaterials();

	RawMaterial addRawMaterial(RawMaterial rawMaterial);

}
