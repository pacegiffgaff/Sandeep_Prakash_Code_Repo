package com.giffgaff.ims.controller.form;

import com.giffgaff.ims.model.RawMaterial;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class InventoryForm {
    private String rawMaterialName;
    private List<RawMaterial> rawMaterialList;
    private Integer rawMaterialQuantity;

    public InventoryForm() {
    }

    public String getRawMaterialName() {
        return rawMaterialName;
    }

    public void setRawMaterialName(String rawMaterialName) {
        this.rawMaterialName = rawMaterialName;
    }

    public List<RawMaterial> getRawMaterialList() {
        return rawMaterialList;
    }

    public void setRawMaterialList(List<RawMaterial> rawMaterialList) {
        this.rawMaterialList = rawMaterialList;
    }

    public Integer getRawMaterialQuantity() {
        return rawMaterialQuantity;
    }

    public void setRawMaterialQuantity(Integer rawMaterialQuantity) {
        this.rawMaterialQuantity = rawMaterialQuantity;
    }
}
