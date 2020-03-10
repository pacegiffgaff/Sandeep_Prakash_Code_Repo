package com.giffgaff.ims.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="rawmtrl_stock")
public class Inventory extends RawMaterial{

    @Id
    @GeneratedValue
    @Column(name = "inventry_id")
    private Long inventoryId;


    @Column(name = "curr_inventry")
    private BigDecimal totalCurrentInventory;
    @Column(name = "hist_total")
    private long historyTotal;
    public Inventory(){}


    public Long getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(Long inventoryId) {
        this.inventoryId = inventoryId;
    }

    public BigDecimal getTotalCurrentInventory() {
        return totalCurrentInventory;
    }

    public void setTotalCurrentInventory(BigDecimal totalCurrentInventory) {
        this.totalCurrentInventory = totalCurrentInventory;
    }

    public long getHistoryTotal() {
        return historyTotal;
    }

    public void setHistoryTotal(long historyTotal) {
        this.historyTotal = historyTotal;
    }
}
