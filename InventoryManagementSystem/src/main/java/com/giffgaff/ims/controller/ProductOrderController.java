package com.giffgaff.ims.controller;

import com.giffgaff.ims.controller.form.ProductOrderForm;
import com.giffgaff.ims.model.Order;
import com.giffgaff.ims.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductOrderController {

    @Autowired
    OrderService orderService;

    @GetMapping("orderForm")
    public String showOrderForm(Model model) {
        model.addAttribute("orderForm",new ProductOrderForm());
        return "jsp/orderForm";
    }

    @PostMapping("/order")
    public Order placeOrder(@RequestBody ProductOrderForm productOrderForm) {
        orderService.placeOrder(productOrderForm);
        return null;
    }


}
