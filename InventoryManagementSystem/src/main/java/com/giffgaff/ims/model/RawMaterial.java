package com.giffgaff.ims.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@MappedSuperclass
public class RawMaterial {

    @Column(name="item_name")
    private String materialName;
    @Column(name="unit_price")
    private BigDecimal pricePerUnit;
    @Column(name="quantity")
    private int quantity;

    @Column(name="unit_price")
    private BigDecimal pricePerQuantity;

    public RawMaterial(){}

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
