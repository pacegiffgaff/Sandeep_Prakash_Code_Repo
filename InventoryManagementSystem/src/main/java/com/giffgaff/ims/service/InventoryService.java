package com.giffgaff.ims.service;

import com.giffgaff.ims.controller.form.InventoryForm;
import com.giffgaff.ims.model.Inventory;
import com.giffgaff.ims.model.RawMaterial;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
public interface InventoryService {
    List<String> getRawMaterialList();

    List<Inventory> getInventoryOfAllRawMaterials();

    List<Inventory> addNewRawmaterialOrUpdateRawMaterialQuantity(InventoryForm inventoryForm, String action);
}
