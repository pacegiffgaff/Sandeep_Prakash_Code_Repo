package com.giffgaff.ims.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity(name = "ProductOrder")
@Table(name="prod_order")
public class ProductOrder {

    @EmbeddedId
    private ProductOrderId id = new ProductOrderId();

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("productId")
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("orderId")
    private Order order;

    @Column(name = "created_on")
    private Date createdOn = new Date();

    private int quantity;

    public ProductOrder() {
    }

    public ProductOrder(Product product, Order order) {
        this.product = product;
        this.order = order;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductOrder that = (ProductOrder) o;
        return
                Objects.equals(product, that.product) &&
                Objects.equals(order, that.order) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(product, order);
    }

    public ProductOrderId getId() {
        return id;
    }

    public void setId(ProductOrderId id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }
}
