package com.giffgaff.ims.service.impl;

import com.giffgaff.ims.controller.form.InventoryForm;
import com.giffgaff.ims.dao.InventoryDAO;
import com.giffgaff.ims.dao.RawMaterialDAO;
import com.giffgaff.ims.model.Inventory;
import com.giffgaff.ims.model.RawMaterial;
import com.giffgaff.ims.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    InventoryDAO inventoryDAO;
    @Autowired
    RawMaterialDAO rawMaterialDAO;

    @Override
    public List<String> getRawMaterialList() {
        List<String> rawMaterialNameList = new ArrayList<>();
        List<RawMaterial> rawMaterialList = rawMaterialDAO.findAll();
        if (rawMaterialList != null) {

            rawMaterialList.forEach(rawMaterial -> rawMaterialNameList.add(rawMaterial.getRawMaterialName()));
            return rawMaterialNameList;
        }
        return null;
    }

    @Override
    public List<Inventory> getInventoryOfAllRawMaterials() {
        return inventoryDAO.findAll();
    }

    @Override
    public Inventory addNewRawmaterialOrUpdateRawMaterialQuantity(InventoryForm inventoryForm, String action) {
        String rawMaterialName = inventoryForm.getRawMaterialName();
        Integer rawMaterialQuantity = inventoryForm.getRawMaterialQuantity();
        Inventory inventory = inventoryDAO.findByRawMaterial_RawMaterialName(rawMaterialName);
        if (inventory != null) {
            Integer totalCurrentInventory = inventory.getTotalCurrentInventory();
            Long historyTotal = inventory.getHistoryTotal();
            if (action.equalsIgnoreCase("ADD")) {
                totalCurrentInventory += rawMaterialQuantity;
                historyTotal += rawMaterialQuantity;
                inventory.setHistoryTotal(historyTotal);

            }else{
                totalCurrentInventory -= rawMaterialQuantity;
                totalCurrentInventory= (totalCurrentInventory< 0) ?0: totalCurrentInventory;
            }
            inventory.setTotalCurrentInventory(totalCurrentInventory);
            inventory= inventoryDAO.save(inventory);
            return inventory;
        }
        inventory = addNewRawMaterialToInventory(rawMaterialName, rawMaterialQuantity);
        return inventory;
    }

    private Inventory addNewRawMaterialToInventory(String rawMaterialName, Integer rawMaterialQuantity) {
        Inventory inventory = new Inventory();
        inventory.setTotalCurrentInventory(rawMaterialQuantity);
        inventory.setHistoryTotal(rawMaterialQuantity);

        RawMaterial rawMaterial = new RawMaterial();
        rawMaterial.setRawMaterialName(rawMaterialName);
        RawMaterial rawMaterialSaved = rawMaterialDAO.save(rawMaterial);
        inventory.setRawMaterial(rawMaterialSaved);
        inventory = inventoryDAO.save(inventory);
        return inventory;
    }

}
