package com.giffgaff.ims.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.giffgaff.ims.model.Product;
import com.giffgaff.ims.model.Stock;
import com.giffgaff.ims.service.StockMgmtService;

@Controller
public class StockMgmtController {

	private static final Logger logger = Logger.getLogger(StockMgmtController.class);

	@Autowired
	StockMgmtService stockMgmtService;

	/**
	 * Display stock details from database
	 * 
	 * @param Model
	 * @return Stocks.jsp
	 */
	@RequestMapping("/stocks")
	public String getAllStock(Model model) {
		logger.info("To dispaly stock Information");
		model.addAttribute("stocks", stockMgmtService.getAllStock());
		return "stocks";
	}

	/**
	 * Add Stock to Database
	 * 
	 * @return
	 */
	@RequestMapping(value = "/stock", method = RequestMethod.GET)
	public ModelAndView showForm() {
		return new ModelAndView("addStock", "stock", new Stock());
	}

	/**
	 * Add stock to database
	 * 
	 * @param stock
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/addStock", method = RequestMethod.POST)
	public String addStock(@ModelAttribute("stock") Stock stock, Model model) {
		model.addAttribute("addStock", stockMgmtService.addStock(stock));
		return "success";
	}

	/**
	 * update all products in stock
	 * 
	 * @param lot
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/stocks/{lot}", method = RequestMethod.PUT)
	public String updateAllProductsInStock(int lot, Model model) {
		model.addAttribute("updateAllProducts", stockMgmtService.updateAllProductsInStock(lot));
		return "success";
	}

	/**
	 * update specific product in stock
	 * 
	 * @param product
	 * @param lot
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/stock/{lot}", method = RequestMethod.PUT)
	public String updateProductInStock(@ModelAttribute("product") Product product, Integer lot, Model model) {
		model.addAttribute("updateProduct", stockMgmtService.updateProductInStock(product, lot));
		return "success";
	}

}
