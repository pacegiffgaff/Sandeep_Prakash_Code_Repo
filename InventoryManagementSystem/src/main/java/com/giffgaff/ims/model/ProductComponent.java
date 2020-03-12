package com.giffgaff.ims.model;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;

@Entity
@Table(name="prod_component")
public class ProductComponent{

    @Id
    @GeneratedValue(
            strategy= GenerationType.AUTO,
            generator="native"
    )
    @GenericGenerator(
            name = "native",
            strategy = "native"
    )
    @Column(name="prod_comp_id")
    private Long id;

    @Column(name="quantity")
    private int quantity;

    @ManyToOne()
    @JoinColumn(name="raw_material_id", insertable = false, updatable = false)
    private RawMaterial rawMaterial;

    public ProductComponent() {    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public RawMaterial getRawMaterial() {
        return rawMaterial;
    }

    public void setRawMaterial(RawMaterial rawMaterial) {
        this.rawMaterial = rawMaterial;
    }
}
