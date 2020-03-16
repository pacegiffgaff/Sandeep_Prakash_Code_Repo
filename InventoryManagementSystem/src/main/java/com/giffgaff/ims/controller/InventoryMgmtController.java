package com.giffgaff.ims.controller;

import com.giffgaff.ims.controller.form.InventoryForm;
import com.giffgaff.ims.model.Inventory;
import com.giffgaff.ims.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class InventoryMgmtController {
    @Autowired
    InventoryService inventoryService;

    @RequestMapping(value = "/inventoryForm", method = RequestMethod.GET)
    public String showAddRawmaterialsToInventoryForm(ModelMap model){
        model.addAttribute("inventoryForm",new InventoryForm());
        List<String> rawMaterialList = inventoryService.getRawMaterialList();
        model.addAttribute("rawMaterialList",rawMaterialList);
        return "inventoryForm";
    }

    @PostMapping("/inventory")
    public String addRawmaterialsToInventory(@RequestParam("action") String action, InventoryForm inventoryForm, Model model){
        List<Inventory>  inventory=  inventoryService.addNewRawmaterialOrUpdateRawMaterialQuantity(inventoryForm, action);
        model.addAttribute("inventory",inventory);
        return "inventory";
    }

    @GetMapping("/inventory")
    public String showInventory(Model model){
        List<Inventory>  inventory=  inventoryService.getInventoryOfAllRawMaterials();
        model.addAttribute("inventory",inventory);
        return "inventory";
    }
}
