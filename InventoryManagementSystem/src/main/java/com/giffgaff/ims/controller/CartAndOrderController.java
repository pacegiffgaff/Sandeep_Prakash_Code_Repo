package com.giffgaff.ims.controller;

import com.giffgaff.ims.controller.form.ProductOrderForm;
import com.giffgaff.ims.model.Order;
import com.giffgaff.ims.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class CartAndOrderController {

    @Autowired
    OrderService orderService;

    @GetMapping("/cart/{productName}")
    @ResponseBody
    public  String addProductToCart(@PathVariable String productName){
        orderService.addProductToCart(productName);
        return "helooo";
    }



    @GetMapping("/cartView")
    public String showOrderForm(Model model) {
        ProductOrderForm productOrderForm= new ProductOrderForm();
        Map<String,Integer> prodQuantityMap = orderService.getProductAndQuantityOfLoggedInUser();
        productOrderForm.setOrderMap(prodQuantityMap);
        model.addAttribute("orderForm",productOrderForm);

        return "jsp/cartView";
    }

    @PostMapping("/order")
    public Order placeOrder(ProductOrderForm productOrderForm) {
        orderService.placeOrder(productOrderForm);
        return null;
    }

}
