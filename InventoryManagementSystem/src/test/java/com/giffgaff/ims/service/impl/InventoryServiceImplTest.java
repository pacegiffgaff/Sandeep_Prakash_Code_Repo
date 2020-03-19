package com.giffgaff.ims.service.impl;

import com.giffgaff.ims.dao.RawMaterialDAO;
import com.giffgaff.ims.model.RawMaterial;
import com.giffgaff.ims.service.InventoryService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
class InventoryServiceImplTest {

    @Mock
    RawMaterialDAO rawMaterialDAO;

    @InjectMocks
    InventoryServiceImpl inventoryService;

    @Test
    void getRawMaterialList() {
        List<String> rawMaterialNameListExpected = new ArrayList<>();
        rawMaterialNameListExpected.add("Apple");

        RawMaterial rawMaterial = new RawMaterial();
        rawMaterial.setRawMaterialName("Apple");
        List<RawMaterial> rawMaterialList = new ArrayList<>();
        rawMaterialList.add(rawMaterial);
        when(rawMaterialDAO.findAll()).thenReturn(rawMaterialList);
        assertEquals(rawMaterialNameListExpected,inventoryService.getRawMaterialList());

    }

    @Test
    void getInventoryOfAllRawMaterials() {
    }

    @Test
    void addNewRawmaterialOrUpdateRawMaterialQuantity() {
    }
}