package com.giffgaff.ims.service.impl;

import com.giffgaff.ims.controller.form.ProductOrderForm;
import com.giffgaff.ims.dao.OrderDAO;
import com.giffgaff.ims.dao.ProductDAO;
import com.giffgaff.ims.model.Order;
import com.giffgaff.ims.model.Product;
import com.giffgaff.ims.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderDAO orderDAO;

    @Autowired
    ProductDAO productDAO;

    @Override
    public void placeOrder(ProductOrderForm productOrderForm) {
        Map<String, Integer> productNameAndQuantityList = productOrderForm.getProductNameAndQuantityList();
        Order order = new Order();
        for (Map.Entry<String, Integer> productNameAndQuantity : productNameAndQuantityList.entrySet()) {
            String productname = productNameAndQuantity.getKey();
            Integer quantity = productNameAndQuantity.getValue();
            Product product = productDAO.findByProductName(productname);
            order.addProduct(product, quantity);

        }
        order = orderDAO.save(order);

    }
}
