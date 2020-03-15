package com.giffgaff.ims.model;

import org.hibernate.annotations.Cascade;
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
    private Integer totalCurrentInventory;

    @Column(name = "history_total")
    private Long historyTotal;

    @OneToOne(cascade= CascadeType.ALL, orphanRemoval = true)
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

    public Integer getTotalCurrentInventory() {
        return totalCurrentInventory;
    }

    public void setTotalCurrentInventory(Integer totalCurrentInventory) {
        this.totalCurrentInventory = totalCurrentInventory;
    }

    public void setHistoryTotal(Long historyTotal) {
        this.historyTotal = historyTotal;
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
