package com.giffgaff.ims.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@MappedSuperclass
public class RawMaterial {

    @Id
    @GeneratedValue()
    @Column(name="rawmtrl_id")
    private Long rawMaterialId;
    @Column(name="item_name")
    private String materialName;
    @Column(name="item_price")
    private BigDecimal materialPrice;
    @Column(name="quantity")
    private int quantity;

    @ManyToMany(mappedBy = "products")
    private List<Product> products;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public RawMaterial(){}

    public Long getRawMaterialId() {
        return rawMaterialId;
    }

    public void setRawMaterialId(Long rawMaterialId) {
        this.rawMaterialId = rawMaterialId;
    }

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
