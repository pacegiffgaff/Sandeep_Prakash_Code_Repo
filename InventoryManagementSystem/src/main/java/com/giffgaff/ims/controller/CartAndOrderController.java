package com.giffgaff.ims.controller;

import com.giffgaff.ims.controller.form.ProductOrderForm;
import com.giffgaff.ims.model.Order;
import com.giffgaff.ims.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class CartAndOrderController {

    @Autowired
    OrderService orderService;

    @GetMapping("/cart/{productName}")
    public  String addProductToCart(@PathVariable String productName){
        orderService.addProductToCart(productName);
        return "helooo";
    }

    /*@RequestMapping(value='/{time}', method = RequestMethod.GET)
    public @ResponseBody MyData getMyData(
            @PathVariable long time) {

        return new MyData(time, 'REST GET Call !!!');
    }*/

    @GetMapping("orderForm")
    public String showOrderForm(Model model) {
        ProductOrderForm productOrderForm= new ProductOrderForm();
        Map<String,Integer> prodQuantityMap = orderService.getProductAndQuantityOfLoggedInUser();
        productOrderForm.setProductNameAndQuantityList(prodQuantityMap);
        model.addAttribute("orderForm",productOrderForm);

        return "jsp/orderForm";
    }

    @PostMapping("/order")
    public Order placeOrder(@RequestBody ProductOrderForm productOrderForm) {
        orderService.placeOrder(productOrderForm);
        return null;
    }

}
