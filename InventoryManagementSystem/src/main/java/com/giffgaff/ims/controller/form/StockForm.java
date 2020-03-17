package com.giffgaff.ims.controller.form;

import org.springframework.stereotype.Component;

@Component
public class StockForm {
    private String productName;
    private int quantity;

    public StockForm() {
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
