package com.giffgaff.ims.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Stock {

    @Id
    @GeneratedValue
    long stockId;

    @OneToOne
    Product product;

    @Column(name = "curr_stock")
    private int totalCurrentStock;

    @Column(name = "hist_total")
    private long historyTotal;

    public Stock(){}

    public long getStockId() {
        return stockId;
    }

    public void setStockId(long stockId) {
        this.stockId = stockId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getTotalCurrentStock() {
        return totalCurrentStock;
    }

    public void setTotalCurrentStock(int totalCurrentStock) {
        this.totalCurrentStock = totalCurrentStock;
    }

    public long getHistoryTotal() {
        return historyTotal;
    }

    public void setHistoryTotal(long historyTotal) {
        this.historyTotal = historyTotal;
    }
}
