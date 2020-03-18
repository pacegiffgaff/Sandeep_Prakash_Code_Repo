package com.giffgaff.ims.dao;

import com.giffgaff.ims.model.RawMaterial;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RawMaterialDAO extends JpaRepository<RawMaterial, Long> {

    RawMaterial findByRawMaterialName(String rawMaterialName);
    
    @Query(value = "SELECT u FROM RawMaterial u WHERE u.rawMaterialName IN :names")
    List<RawMaterial> findRawmaterialsByNameList(@Param("names") Collection<String> names);
}
