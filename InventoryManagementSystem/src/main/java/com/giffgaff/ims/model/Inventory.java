package com.giffgaff.ims.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "inventory")
public class Inventory {

    @Id
    @GeneratedValue(
            strategy= GenerationType.AUTO,
            generator="native"
    )
    @GenericGenerator(
            name = "native",
            strategy = "native"
    )
    @Column(name="inventory_Id")
    private Long inventoryId;

    @Column(name = "inventory_name")
    private String inventoryName;

    @Column(name = "totalCurrent_inventory")
    private BigDecimal totalCurrentInventory;

    @Column(name = "history_total")
    private long historyTotal;

    @OneToOne
    private RawMaterial rawMaterial;

    public Inventory(){}

    public Long getInventoryId() {
        return inventoryId;
    }

    public void setInventory_Id(Long inventoryId) {
        this.inventoryId = inventoryId;
    }

    public String getInventoryName() {
        return inventoryName;
    }

    public void setInventoryName(String inventoryName) {
        this.inventoryName = inventoryName;
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

    public RawMaterial getRawMaterial() {
        return rawMaterial;
    }

    public void setRawMaterial(RawMaterial rawMaterial) {
        this.rawMaterial = rawMaterial;
    }
}
