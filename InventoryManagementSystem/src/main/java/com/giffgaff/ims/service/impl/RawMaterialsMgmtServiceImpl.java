package com.giffgaff.ims.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.giffgaff.ims.dao.InventoryDAO;
import com.giffgaff.ims.dao.RawMaterialMgmtDAO;
import com.giffgaff.ims.model.Inventory;
import com.giffgaff.ims.model.Product;
import com.giffgaff.ims.service.RawMaterialsMgmtService;

@Component
public class RawMaterialsMgmtServiceImpl implements RawMaterialsMgmtService {

	private static final Logger logger = Logger.getLogger(RawMaterialsMgmtServiceImpl.class);

	@Autowired
	InventoryDAO inventoryDAO;

	@Autowired
	RawMaterialMgmtDAO rawMaterialMgmtDAO;

	@Override
	public List<Product> getRawMaterialsWithSpecs() {
		List<Product> rawMaterialProdList = rawMaterialMgmtDAO.findAll();
		for (Product product : rawMaterialProdList) {
			logger.info("product ID:" + product.getProductId() + "\n Product Name :" + product.getProductName()
					+ "\n Raw Meterials :" + product.getProductComponentList().get(0).getRawMaterial()
					+ "\n Product Specifications :" + product.getSpecifications());
		}
		return rawMaterialProdList;
	}

	@Override
	public List<Inventory> trackRawmaterials() {
		List<Inventory> trackRawMaterialList = inventoryDAO.findAll();
		for (Inventory inventory : trackRawMaterialList) {
			logger.info("Inventory ID :" + inventory.getInventoryId() + "\n Inventory Name :"
					+ inventory.getInventoryName() + "\n Inventory History total :" + inventory.getHistoryTotal()
					+ "\n Inventory Raw Material :" + inventory.getRawMaterial() + "\n Total Currency"
					+ inventory.getTotalCurrentInventory());
		}
		return trackRawMaterialList;
	}
}
