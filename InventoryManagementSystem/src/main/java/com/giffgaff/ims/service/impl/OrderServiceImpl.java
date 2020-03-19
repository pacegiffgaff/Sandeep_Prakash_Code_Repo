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
import com.giffgaff.ims.service.IAuthenticationFacade;
import com.giffgaff.ims.service.OrderService;
import com.giffgaff.ims.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Component
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderDAO orderDAO;

    @Autowired
    ProductDAO productDAO;

    @Autowired
    CartDAO cartDAO;

    @Autowired
    IAuthenticationFacade authenticationFacade;

    @Autowired
    UserRepository userRepository;

    @Autowired


    @Override
    public void placeOrder(ProductOrderForm productOrderForm) {
        Map<String, Integer> productNameAndQuantityList = productOrderForm.getOrderMap();
        if (productNameAndQuantityList.size() == 0) {
            return;
        }
        Order order = new Order();
        Authentication authentication = authenticationFacade.getAuthentication();
        String userName= authentication.getName();
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
        Authentication authentication = authenticationFacade.getAuthentication();
        String userName= authentication.getName();
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

    public Cart getCartOfLoggedInUser() {
        Authentication authentication = authenticationFacade.getAuthentication();
        String userName= authentication.getName();
        Cart cart =cartDAO.findByUser_Username(userName);
        return cart;
    }

    public Map<String,Integer> getProductAndQuantityOfLoggedInUser(){
        Cart cart= getCartOfLoggedInUser();
        Set<Product> productList= cart.getProducts();
        Map<String, Integer> prodQuantity = new HashMap<>();
        productList.forEach(product -> {
            prodQuantity.put(product.getProductName(),0);
        });
        return prodQuantity;
    }

}
