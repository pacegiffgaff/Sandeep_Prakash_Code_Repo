package com.giffgaff.ims.service.impl;

import com.giffgaff.ims.controller.form.ProductOrderForm;
import com.giffgaff.ims.dao.CartDAO;
import com.giffgaff.ims.dao.OrderDAO;
import com.giffgaff.ims.dao.ProductDAO;
import com.giffgaff.ims.dao.UserRepository;
import com.giffgaff.ims.model.Cart;
import com.giffgaff.ims.model.Order;
import com.giffgaff.ims.model.Product;
import com.giffgaff.ims.model.User;
import com.giffgaff.ims.service.OrderService;
import com.giffgaff.ims.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderDAO orderDAO;

    @Autowired
    ProductDAO productDAO;

    @Autowired
    CartDAO cartDAO;

    @Autowired
    SecurityService securityService;

    @Autowired
    UserRepository userRepository;

    @Autowired


    @Override
    public void placeOrder(ProductOrderForm productOrderForm) {
        Map<String, Integer> productNameAndQuantityList = productOrderForm.getProductNameAndQuantityList();
        if (productNameAndQuantityList.size() == 0) {
            return;
        }
        Order order = new Order();
        String userName= securityService.findLoggedInUsername();
        User user = userRepository.findByUsername(userName);

        for (Map.Entry<String, Integer> productNameAndQuantity : productNameAndQuantityList.entrySet()) {
            String productname = productNameAndQuantity.getKey();
            Integer quantity = productNameAndQuantity.getValue();
            if(quantity==null || quantity.equals(0)){
                continue;
            }
            Product product = productDAO.findByProductName(productname);
            order.addProduct(product, quantity);

        }
        order.setUser(user);
        order = orderDAO.save(order);

    }

    @Override
    public void addProductToCart(String prodName) {
        Product product= productDAO.findByProductName(prodName);
        String userName= securityService.findLoggedInUsername();
        Cart cart =cartDAO.findByUser_Username(userName);
        if (cart != null) {
            cart.getProducts().add(product);
            cartDAO.save(cart);
         return ;
        }
        cart = new Cart();

        User user = userRepository.findByUsername(userName);
        cart.setUser(user);
        cartDAO.save(cart);
    }
}
