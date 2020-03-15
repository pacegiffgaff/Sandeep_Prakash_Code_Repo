package com.giffgaff.ims.dao;

import com.giffgaff.ims.model.Inventory;
import com.giffgaff.ims.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.giffgaff.ims.model.Product;

@Repository
public interface InventoryDAO extends JpaRepository<Inventory, Long> {

    @Modifying
    @Query("update Inventory inv set inv.totalCurrentInventory = inv.totalCurrentInventory -  :lot , inv.historyTotal = inv.historyTotal -  :lot")
    Integer updateRawmaterialonProduction(@Param("lot") Integer lot);

    Inventory findByRawMaterial_RawMaterialName(String rawMaterialName);
}
