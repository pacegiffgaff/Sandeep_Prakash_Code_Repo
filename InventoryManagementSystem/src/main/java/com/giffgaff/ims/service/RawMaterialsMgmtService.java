package com.giffgaff.ims.service;

import java.util.List;

import com.giffgaff.ims.model.Inventory;
import com.giffgaff.ims.model.Product;

public interface RawMaterialsMgmtService {

	List<Product> getRawMaterialsWithSpecs();

	List<Inventory> trackRawmaterials();

}
