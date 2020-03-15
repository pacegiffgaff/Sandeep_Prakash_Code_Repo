package com.giffgaff.ims.service.impl;

import com.giffgaff.ims.controller.form.InventoryForm;
import com.giffgaff.ims.dao.InventoryDAO;
import com.giffgaff.ims.dao.RawMaterialDao;
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
    RawMaterialDao rawMaterialDao;

    @Override
    public List<String> getRawMaterialList() {
        List<String> rawMaterialNameList = new ArrayList<>();
        List<RawMaterial> rawMaterialList = rawMaterialDao.findAll();
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
    public List<Inventory> addNewRawmaterialOrUpdateRawMaterialQuantity(InventoryForm inventoryForm, String action) {
        String rawMaterialName = inventoryForm.getRawMaterialName();
        Integer rawMaterialQuantity = inventoryForm.getRawMaterialQuantity();
        Inventory inventory = inventoryDAO.findByRawMaterial_RawMaterialName(rawMaterialName);
        if (inventory != null) {
            Integer totalCurrentInventory = inventory.getTotalCurrentInventory();
            Long historyTotal = inventory.getHistoryTotal();
            Integer totalCurrentInventoryCalculated = totalCurrentInventory;
            Long historyTotalCalculated= historyTotal;
            if (action.equalsIgnoreCase("ADD")) {
                totalCurrentInventoryCalculated = totalCurrentInventory + rawMaterialQuantity;
                 historyTotalCalculated = historyTotal + rawMaterialQuantity;
            }else{
                totalCurrentInventoryCalculated = totalCurrentInventory - rawMaterialQuantity;
                totalCurrentInventoryCalculated= (totalCurrentInventoryCalculated< 0) ?0: totalCurrentInventoryCalculated;
                historyTotalCalculated = historyTotal - rawMaterialQuantity;
                historyTotalCalculated= (historyTotalCalculated< 0) ?0: historyTotalCalculated;

            }
            inventory.setTotalCurrentInventory(totalCurrentInventoryCalculated);
            inventory.setHistoryTotal(historyTotalCalculated);
            inventoryDAO.save(inventory);
            return inventoryDAO.findAll();
        }
        addNewRawMaterialToInventory(rawMaterialName, rawMaterialQuantity);
        return inventoryDAO.findAll();
    }

    private void addNewRawMaterialToInventory(String rawMaterialName, Integer rawMaterialQuantity) {
        Inventory inventory = new Inventory();
        inventory.setTotalCurrentInventory(rawMaterialQuantity);
        inventory.setHistoryTotal(rawMaterialQuantity);

        RawMaterial rawMaterial = new RawMaterial();
        rawMaterial.setRawMaterialName(rawMaterialName);
        RawMaterial rawMaterialSaved = rawMaterialDao.save(rawMaterial);
        inventory.setRawMaterial(rawMaterialSaved);
        inventoryDAO.save(inventory);
    }

}
