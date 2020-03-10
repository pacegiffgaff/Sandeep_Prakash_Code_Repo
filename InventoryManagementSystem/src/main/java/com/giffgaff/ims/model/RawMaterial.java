package com.giffgaff.ims.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@MappedSuperclass
public class RawMaterial {

    @Column(name="item_name")
    private String materialName;
    @Column(name="item_price")
    private BigDecimal materialPrice;
    @Column(name="quantity")
    private int quantity;

    public RawMaterial(){}

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    public BigDecimal getMaterialPrice() {
        return materialPrice;
    }

    public void setMaterialPrice(BigDecimal materialPrice) {
        this.materialPrice = materialPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
