package com.giffgaff.ims.service;

import com.giffgaff.ims.controller.form.ProductOrderForm;
import com.giffgaff.ims.model.Cart;

import java.util.Map;

public interface OrderService {

    public void placeOrder(ProductOrderForm productOrderForm);

    public void addProductToCart(String productName);

    public Cart getCartOfLoggedInUser();

    public Map<String,Integer> getProductAndQuantityOfLoggedInUser();

    }
