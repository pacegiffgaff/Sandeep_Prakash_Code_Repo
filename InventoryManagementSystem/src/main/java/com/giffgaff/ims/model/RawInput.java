package com.giffgaff.ims.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="rawmtrl")
public class RawInput extends RawMaterial{

    @ManyToMany(mappedBy = "products")
    private List<Product> products;

    @Column(name="quantity")
    private int quantity;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public RawInput(){}

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
