package com.giffgaff.ims.controller.form;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ProductOrderForm {

    Map<String, Integer> productNameAndQuantityList = new HashMap<>();

    public ProductOrderForm() {
    }

    public Map<String, Integer> getProductNameAndQuantityList() {
        return productNameAndQuantityList;
    }

    public void setProductNameAndQuantityList(Map<String, Integer> productNameAndQuantityList) {
        this.productNameAndQuantityList = productNameAndQuantityList;
    }
}
