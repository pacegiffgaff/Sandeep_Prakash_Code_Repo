package com.giffgaff.ims.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.giffgaff.ims.controller.form.InventoryForm;
import com.giffgaff.ims.dao.InventoryDAO;
import com.giffgaff.ims.dao.RawMaterialDAO;
import com.giffgaff.ims.model.Inventory;
import com.giffgaff.ims.model.RawMaterial;

@ExtendWith(MockitoExtension.class)
public class InventoryServiceImplTest {

	
	@InjectMocks
	private InventoryServiceImpl inventoryServiceImpl;
	
	@Mock
    InventoryDAO inventoryDAO;
    @Mock
    RawMaterialDAO rawMaterialDAO;
    
    static List<RawMaterial> rawMaterialList = new ArrayList<>();
    static InventoryForm inventoryForm = new InventoryForm();
    static Inventory inventory = new Inventory();
    @BeforeAll
    public static void init() {
    	
		 RawMaterial rm1 = new RawMaterial();
		 rm1.setRawMaterialId((long) 12345);
		 rm1.setRawMaterialName("Raw material");
		 rawMaterialList.add(rm1);
		 
		 inventoryForm.setRawMaterialName("Mango");
		 inventoryForm.setRawMaterialQuantity(1000);
		 
		 inventory.setTotalCurrentInventory(1000);
		 inventory.setHistoryTotal(100);
    }
    
	 @Test
	 public void test_WhenRawMaterialList_NotAvailable() {
		 doReturn(null).when(rawMaterialDAO).findAll();
		 List<String> nameList = inventoryServiceImpl.getRawMaterialList();
		 assertEquals(nameList, null);
		 
	 }
	 
	 @Test
	 public void test_WhenRawMaterialList_Available() {
		 doReturn(rawMaterialList).when(rawMaterialDAO).findAll();
		 List<String> nameList = inventoryServiceImpl.getRawMaterialList();
		 
		 assertEquals(nameList.size(), 1);
		 
		 assertEquals(nameList.get(0), "Raw material");
		 
	 }
		 
	 @Test
	 public void test_WithNullInventory() {
		 doReturn(null).when(inventoryDAO).findByRawMaterial_RawMaterialName(inventoryForm.getRawMaterialName());
		 
		 doReturn(inventory).when(inventoryDAO).save(any(Inventory.class));
		 Inventory inventory = inventoryServiceImpl.addNewRawmaterialOrUpdateRawMaterialQuantity(inventoryForm, null);
		 
		 assertNotEquals(inventory, null);
		 
		 assertEquals(inventory.getTotalCurrentInventory(), 1000);
		 
	 }
	 
	 @Test
	 public void test_WithInventory_Remove() {
		 doReturn(inventory).when(inventoryDAO).findByRawMaterial_RawMaterialName(inventoryForm.getRawMaterialName());
		 
		 doReturn(inventory).when(inventoryDAO).save(any(Inventory.class));
		 Inventory inventory = inventoryServiceImpl.addNewRawmaterialOrUpdateRawMaterialQuantity(inventoryForm, "Remove");
		 
		 assertNotEquals(inventory, null);
		 
		 assertEquals(inventory.getTotalCurrentInventory(), 0);
		 
	 }
	 
	 @Test
	 public void test_WithInventory_Add() {
		 doReturn(inventory).when(inventoryDAO).findByRawMaterial_RawMaterialName(inventoryForm.getRawMaterialName());
		 
		 doReturn(inventory).when(inventoryDAO).save(any(Inventory.class));
		 Inventory inventory = inventoryServiceImpl.addNewRawmaterialOrUpdateRawMaterialQuantity(inventoryForm, "ADD");
		 
		 assertNotEquals(inventory, null);
		 
		 assertEquals(inventory.getTotalCurrentInventory(), 2000);
		 
	 }
	 
}
