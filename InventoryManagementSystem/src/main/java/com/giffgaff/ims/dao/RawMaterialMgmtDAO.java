package com.giffgaff.ims.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.giffgaff.ims.model.Product;

public interface RawMaterialMgmtDAO extends JpaRepository<Product, Long> {

}
