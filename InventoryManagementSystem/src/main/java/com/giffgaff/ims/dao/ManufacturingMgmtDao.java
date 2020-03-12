package com.giffgaff.ims.dao;

import com.giffgaff.ims.model.Inventory;
import com.giffgaff.ims.model.RawMaterial;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManufacturingMgmtDao extends CrudRepository<RawMaterial, Long> {
}
