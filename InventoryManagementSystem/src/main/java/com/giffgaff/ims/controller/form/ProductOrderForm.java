package com.giffgaff.ims.controller.form;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ProductOrderForm {

    Map<String, Integer> orderMap = new HashMap<>();

    public ProductOrderForm() {
    }


    public void setOrderMap(Map<String, Integer> productNameAndQuantityList) {
        this.orderMap = productNameAndQuantityList;
    }

    public Map<String, Integer> getOrderMap() {
        return orderMap;
    }
}
