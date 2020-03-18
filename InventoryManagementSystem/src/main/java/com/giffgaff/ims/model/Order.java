package com.giffgaff.ims.model;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name="cust_order")
public class Order {
    @Id
    @GeneratedValue
    @Column(name = "order_id")
    private Long orderId;

    @OneToMany(
            mappedBy = "order",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<ProductOrder> products = new ArrayList<>();

    @ManyToOne
    User user;

    @OneToOne
    private Address address;
    private boolean cart = true;

    public Order() {
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public List<ProductOrder> getProducts() {
        return products;
    }

    public void setProducts(List<ProductOrder> products) {
        this.products = products;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Address getAddress() {
        return address;
    }

    public boolean isCart() {
        return cart;
    }

    public void setCart(boolean cart) {
        this.cart = cart;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(orderId, order.orderId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId);
    }

    public void addProduct(Product product, int quantity) {
        ProductOrder productOrders = new ProductOrder(product,this);
        productOrders.setQuantity(quantity);
        products.add(productOrders);
    }

}
