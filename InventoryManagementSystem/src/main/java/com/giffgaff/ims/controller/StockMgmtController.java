package com.giffgaff.ims.controller;

import com.giffgaff.ims.controller.form.InventoryForm;
import com.giffgaff.ims.controller.form.StockForm;
import com.giffgaff.ims.model.Inventory;
import com.giffgaff.ims.service.ProductService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.giffgaff.ims.model.Product;
import com.giffgaff.ims.model.Stock;
import com.giffgaff.ims.service.StockMgmtService;

import java.util.List;

import javax.validation.Valid;

@Controller
public class StockMgmtController {

	private static final Logger logger = Logger.getLogger(StockMgmtController.class);

	@Autowired
	StockMgmtService stockMgmtService;

	@Autowired
	ProductService productService;

	/**
	 * Display stock details from database
	 * 
	 * @param model
	 * @return Stocks.jsp
	 */
	@RequestMapping("/stocks")
	public String getAllStock(Model model) {
		logger.info("To dispaly stock Information");
		model.addAttribute("stocks", stockMgmtService.getAllStock());
		return "jsp/stocks";
	}

	/**
	 * Add Stock to Database
	 * 
	 * @return
	 */
	@RequestMapping(value = "/addStock", method = RequestMethod.GET)
	public String showForm(Model model) {
		List<String> productNames = productService.getAllproductNames();
		model.addAttribute("productNames",productNames);
		model.addAttribute("stockForm", new StockForm());
		return "jsp/addStock";
	}

	/**
	 * update specific product in stock
	 * 
	 * @param stockForm
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/stock", method = RequestMethod.POST)
	public String updateProductInStock(@RequestParam("action") String action,
			@Valid @ModelAttribute StockForm stockForm, Model model, BindingResult bindingResult) {
		ValidationUtils.rejectIfEmptyOrWhitespace(bindingResult, "productName", "NotNull");
		ValidationUtils.rejectIfEmptyOrWhitespace(bindingResult, "quantity", "Min");
		if (bindingResult.hasFieldErrors()) {
			return "jsp/addStock";
		}
		model.addAttribute("stock", stockMgmtService.updateProductInStock(stockForm, action));
		List<String> productNames = productService.getAllproductNames();
		model.addAttribute("productNames",productNames);
		return "jsp/addStock";
	}

}
