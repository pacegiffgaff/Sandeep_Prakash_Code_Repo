package com.giffgaff.ims.controller;

import com.giffgaff.ims.controller.form.InventoryForm;
import com.giffgaff.ims.model.Inventory;
import com.giffgaff.ims.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.validation.Valid;

@Controller
public class InventoryMgmtController {
    @Autowired
    InventoryService inventoryService;

    @RequestMapping(value = "/inventoryForm", method = RequestMethod.GET)
    public String showAddRawmaterialsToInventoryForm(ModelMap model){
        model.addAttribute("inventoryForm",new InventoryForm());
        List<String> rawMaterialList = inventoryService.getRawMaterialList();
        model.addAttribute("rawMaterialList",rawMaterialList);
        return "jsp/inventoryForm";
    }

    @PostMapping("/inventory")
    public String addRawmaterialsToInventory(@Valid @RequestParam("action") String action,
			@Valid InventoryForm inventoryForm, Model model, BindingResult bindingResult) {
		ValidationUtils.rejectIfEmptyOrWhitespace(bindingResult, "rawMaterialName", "NotNull");
		ValidationUtils.rejectIfEmptyOrWhitespace(bindingResult, "rawMaterialQuantity", "NotNull");

		if (bindingResult.hasFieldErrors()) {
			return "jsp/inventoryForm";
		}
		 Inventory  inventory=  inventoryService.addNewRawmaterialOrUpdateRawMaterialQuantity(inventoryForm, action);
        model.addAttribute("inventory",inventory);
        return "jsp/inventoryForm";
    }

    @GetMapping("/inventory")
    public String showInventory(Model model){
        List<Inventory>  inventory=  inventoryService.getInventoryOfAllRawMaterials();
        model.addAttribute("inventory",inventory);
        return "jsp/inventory";
    }
}
